package com.dimc.pattern.dispatcher;

import com.dimc.constants.Constants;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;

public class Dispatcher {
	private GetHandle get = new GetHandle();
	private PostHandle post = new PostHandle();
	private PutHandle put = new PutHandle();
	
	public Dispatcher() {
	}

	public FullHttpResponse dispatch(HttpRequest request) {
		
		switch (request.method().name()) {
		case Constants.GET:
			return get.handle(request);
		case Constants.POST:
			return post.handle(request);
		case Constants.PUT:
			return put.handle(request);
		default:
			throw new UnsupportedOperationException();
		}
	}
}
