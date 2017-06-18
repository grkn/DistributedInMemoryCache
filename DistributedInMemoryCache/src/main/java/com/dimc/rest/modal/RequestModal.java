package com.dimc.rest.modal;

import java.util.Calendar;
import java.util.Date;

public class RequestModal {

	private String request;
	private Date requestDate = Calendar.getInstance().getTime();

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

}
