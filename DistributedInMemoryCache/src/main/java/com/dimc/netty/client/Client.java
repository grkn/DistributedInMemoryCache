package com.dimc.netty.client;

import org.springframework.http.ResponseEntity;

public interface Client<ResponseData,RequestData> {

	public ResponseEntity<ResponseData> doSendByGET(RequestData data, Class<ResponseData> clazz);
	public ResponseEntity<ResponseData> doSendByPOST(RequestData data, Class<ResponseData> clazz);
	public void doSendByPUT(RequestData data, Class<ResponseData> clazz);
	
}
