package com.shoppingzone.model;

public class RequestResult {
	private String refId;
	private String message;
	public RequestResult() {
		
	}
	public RequestResult(String refId, String message) {
		super();
		this.refId = refId;
		this.message = message;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
