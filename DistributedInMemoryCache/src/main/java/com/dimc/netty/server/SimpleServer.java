package com.dimc.netty.server;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLException;

import com.dimc.executors.ExpandableThreadPool;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

public class SimpleServer implements Server{

	private final Integer PORT;
	
	static final boolean SSL = System.getProperty("ssl") != null;
	
	public SimpleServer(Integer port) {
		PORT = port;
	}

	@Override
	public void bootstrap() throws SSLException, CertificateException, InterruptedException {
		final SslContext sslCtx;
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        
        } else {
            sslCtx = null;
        }
        EventLoopGroup bossGroup = new NioEventLoopGroup(THREAD_COUNT_SERVER,new ExpandableThreadPool.Builder().build());
        EventLoopGroup workerGroup = new NioEventLoopGroup(THREAD_COUNT_SERVER,new ExpandableThreadPool.Builder().build());
        
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .handler(new LoggingHandler(SERVER_LOG_LEVEL))
             .childHandler(new ChannelInitializer<Channel>() {
            	
            	@Override
            	protected void initChannel(Channel ch) throws Exception {
            		ChannelPipeline p = ch.pipeline();
                    if (sslCtx != null) {
                        p.addLast(sslCtx.newHandler(ch.alloc()));
                    }
                    p.addLast(new HttpServerCodec());
                    p.addLast(new SimpleServerHandler());
            	}
            	
			});

            Channel ch = b.bind(PORT).sync().channel();

            System.err.println("Open your web browser and navigate to " +
                    (SSL? "https" : "http") + "://127.0.0.1:" + PORT + '/');

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
        
	}

	
	
}
