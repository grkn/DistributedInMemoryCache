package com.dimc.rest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.dimc.netty.client.Client;
import com.dimc.netty.client.SimpleClient;
import com.dimc.rest.modal.RequestModal;
import com.dimc.rest.modal.ResponseModal;


public class SimpleClientTest {

	@Test
	public void getTest(){
		Client<ResponseModal, RequestModal> client = new SimpleClient<ResponseModal, RequestModal>("http://localhost:8099");
		ResponseEntity<ResponseModal> response = client.doSendByGET(new RequestModal(), ResponseModal.class);
		ResponseModal responseModal = response.getBody();
		Assert.assertEquals(responseModal.getResponse(), "HelloWorld");
	}
	
	@Test
	public void postTest(){
		Client<ResponseModal, RequestModal> client = new SimpleClient<ResponseModal, RequestModal>("http://localhost:8099");
		ResponseModal response = client.doSendByPOST(new RequestModal(), ResponseModal.class).getBody();
		Assert.assertEquals(response.getResponse(), "HelloWorld");
	}
	
	@Test
	public void putTest(){
		Client<ResponseModal, RequestModal> client = new SimpleClient<ResponseModal, RequestModal>("http://localhost:8099");
		client.doSendByPUT(new RequestModal(), ResponseModal.class);
	}
	
}
