package com.xworkz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.dto.VaccineVerifyOTPDTO;
import com.xworkz.service.VerifyVaccineOTPService;

@Controller
@RequestMapping("/")
public class VerifyOTPController {

	@Autowired
	private VerifyVaccineOTPService vaccineOTPService;

	public VerifyOTPController() {
		System.out.println(this.getClass().getSimpleName() + " Bean crated ");
	}

	@RequestMapping(value = "/enterVaccineOTP.vaccine")
	public String getVaccineOTPResource() {
		System.out.println("getVaccineResource() Invoked");
		return "VerifyOTPPage";
	}

	@RequestMapping(value = "/verifyOTP.vaccine")
	public String onVerifyOTP(VaccineVerifyOTPDTO vaccineVerifyOTPDTO) {
		System.out.println("onVerifyOTP() Invoked");
		System.out.println(vaccineVerifyOTPDTO);
		boolean isOTPValid = this.vaccineOTPService.validateOTP(vaccineVerifyOTPDTO);
		if (isOTPValid) {
			System.out.println("otp is valid");

		} else {
			System.out.println("otp is invalid");
		}
		return "VerifyOTPPage";
	}
}
