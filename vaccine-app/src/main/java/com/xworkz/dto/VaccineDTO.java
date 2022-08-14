package com.xworkz.dto;

import org.apache.log4j.Logger;

public class VaccineDTO {
	private String userEmail;

	Logger logger = Logger.getLogger(VaccineDTO.class);

	public VaccineDTO() {
		logger.info(this.getClass().getSimpleName() + " Bean crated ");
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "VaccineDTO [userEmail=" + userEmail + "]";
	}

}
