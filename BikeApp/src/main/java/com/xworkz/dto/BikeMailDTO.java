package com.xworkz.dto;

public class BikeMailDTO {
	private String toEmail;
	private String subject;
	private String textBody;
	
	public BikeMailDTO() {
		System.out.println(this.getClass().getSimpleName()+"bean created");
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	@Override
	public String toString() {
		return "BikeMailDTO [toEmail=" + toEmail + ", subject=" + subject + ", textBody=" + textBody + "]";
	}
	
	
}
