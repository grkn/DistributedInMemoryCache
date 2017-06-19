package com.dimc.netty.server;

import static com.dimc.constants.Constants.JSON_CONTENT;

import java.nio.charset.Charset;

import com.dimc.constants.Constants;
import com.dimc.pattern.dispatcher.FrontController;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class SimpleServerHandler extends ChannelInboundHandlerAdapter {

	

    private FrontController frontController = new FrontController();

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		  ctx.flush();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpRequest) {
            HttpRequest req = (HttpRequest) msg;
            
            if (EmptyHttpHeaders.is100ContinueExpected(req)) {
                ctx.write(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.CONTINUE));
            }

            boolean keepAlive = EmptyHttpHeaders.isKeepAlive(req);
            FullHttpResponse response = frontController.dispatchRequest(req);
            
            if(response == null){
            	response = prepareDefaultResponse();
            }
        
            response.headers().set("content-type", "application/json");
            response.headers().set("content-length", response.content().readableBytes());
    	
            if (!keepAlive) {
                ctx.write(response).addListener(ChannelFutureListener.CLOSE);
            } else {
            	response.headers().set("connection", HttpHeaderValues.KEEP_ALIVE);
                ctx.write(response);
            }
        }
	}
	
	private DefaultFullHttpResponse prepareDefaultResponse() {
		return new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(Constants.DEFAULT_CONTENT));
    }

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
        ctx.close();
	}
	
}
