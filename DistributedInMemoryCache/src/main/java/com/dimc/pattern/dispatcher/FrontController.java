package com.dimc.pattern.dispatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;

public class FrontController {

	private Dispatcher dispatcher;
	private Logger log = LoggerFactory.getLogger(FrontController.class);
	
	
	public FrontController(){
	   dispatcher = new Dispatcher();
	}

	private boolean isAuthenticUser() {
		return true;
	}

	private void trackRequest(HttpRequest request) {
		StringBuilder builder = new StringBuilder(request.protocolVersion().text());
		builder.append(request.uri());
		builder.append(request.method().name());
		log.info(builder.toString());
	}

	public FullHttpResponse dispatchRequest(HttpRequest request) {
		// log each request
		trackRequest(request);

		// authenticate the user
		if (isAuthenticUser()) {
			return dispatcher.dispatch(request);
		}
		
		return null;
	}

}
