package com.axis.octate.response;

public class EmailResponse {
	private String message;
	private int otp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public EmailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailResponse(String message, int otp) {
		super();
		this.message = message;
		this.otp = otp;
	}
	

}
