package com.dimc.constants;

import java.nio.charset.Charset;

public interface Constants {

	//Default behavior is final static
	String GET = "GET";
	String POST = "POST";
	String PUT = "PUT";
	String UTF8 = "UTF-8";
	
	byte[] JSON_CONTENT = new String("{\"response\" : \"HelloWorld\"}").getBytes(Charset.forName(UTF8));
	byte[] DEFAULT_CONTENT = new String("{\"response\" : \"NO_RESP\"}").getBytes(Charset.forName(UTF8));
	
	
	//End Point Constants
	String TRANSFER = "/transfer";
	
}
