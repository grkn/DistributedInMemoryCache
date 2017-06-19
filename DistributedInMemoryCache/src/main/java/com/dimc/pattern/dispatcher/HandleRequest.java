package com.dimc.pattern.dispatcher;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;

public interface HandleRequest {

	public FullHttpResponse handle(HttpRequest request);
	
}
