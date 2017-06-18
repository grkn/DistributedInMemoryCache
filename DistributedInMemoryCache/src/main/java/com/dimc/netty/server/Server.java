package com.dimc.netty.server;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLException;

import io.netty.handler.logging.LogLevel;

public interface Server {

	public static Integer PORT = 8099;
	public static final Integer THREAD_COUNT_SERVER = 10;
	public static final Integer MAX_THREAD_COUNT = 50;
	public static final LogLevel SERVER_LOG_LEVEL = LogLevel.INFO;
	
	public void bootstrap() throws SSLException, CertificateException, InterruptedException;
	
}
