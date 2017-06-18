package com.dimc.rest.modal;

import java.util.Calendar;
import java.util.Date;

public class ResponseModal {

	private String response;
	private Date reponseDate = Calendar.getInstance().getTime();

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getReponseDate() {
		return reponseDate;
	}

	public void setReponseDate(Date reponseDate) {
		this.reponseDate = reponseDate;
	}
}
