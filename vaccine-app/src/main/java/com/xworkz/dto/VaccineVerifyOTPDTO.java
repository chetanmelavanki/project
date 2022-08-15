package com.xworkz.dto;

import org.apache.log4j.Logger;

public class VaccineVerifyOTPDTO {
	
	private String otp;
	
	static final Logger logger = Logger.getLogger(VaccineVerifyOTPDTO.class);

	
	public VaccineVerifyOTPDTO() {
		logger.info(this.getClass().getSimpleName() + " Bean crated ");
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "VaccineVerifyOTPDTO [otp=" + otp + "]";
	}
	
	
}
