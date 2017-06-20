package com.dimc.netty.client;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dimc.constants.Constants;

public class SimpleClient<ResponseData,RequestData> implements Client<ResponseData, RequestData>{

	private final String URL;
	private final RestTemplate rest = new RestTemplate();
	
	public SimpleClient(String url) {
		this.URL = url;
	}
	
	@Override
	public ResponseEntity<ResponseData> doSendByGET(RequestData data,Class<ResponseData> clazz) {
		return rest.getForEntity(this.URL,clazz, data);
	}

	@Override
	public ResponseEntity<ResponseData> doSendByPOST(RequestData data,Class<ResponseData> clazz) {
		HttpEntity<ResponseData> request = new HttpEntity<ResponseData>(new HttpHeaders());
		return rest.postForEntity(this.URL,request,clazz, data);
	}

	@Override
	public void doSendByPUT(RequestData data,Class<ResponseData> clazz) {
		HttpEntity<ResponseData> request = new HttpEntity<ResponseData>(new HttpHeaders());
		rest.put(this.URL, request, data);
	}
	
	
	public void putForBytes(byte[] arr){
		String bytes = Base64.getEncoder().encodeToString(arr);
		HttpEntity<ResponseData> request = new HttpEntity<ResponseData>(new HttpHeaders());
		rest.put(new StringBuilder(this.URL).append(Constants.TRANSFER).toString(), request,bytes);
	}
}
