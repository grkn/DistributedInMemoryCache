package com.dimc;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dimc.netty.server.Server;
import com.dimc.netty.server.SimpleServer;

@SpringBootApplication
public class BootStrap implements Boot{

	public static void main(String[] args) {
		  new BootStrap().nettyUp(args.length > 0 ? Integer.parseInt(args[0]): Server.PORT);
		  SpringApplication.run(BootStrap.class, args);
	}

	@Override
	public  void nettyUp(final Integer port) {
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				SimpleServer model = new SimpleServer(port);
				try {
					model.bootstrap();
				} catch (SSLException | CertificateException | InterruptedException e) {
					//netty boot error
					e.printStackTrace();
				}
			}
			
		});
		th.setDaemon(true);
		th.start();
	}
	
}
