package com.xworkz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.dao.VaccineDAO;
import com.xworkz.dto.VaccineVerifyOTPDTO;

@Service
public class VerifyVaccineOTPServiceImpl implements VerifyVaccineOTPService {

	@Autowired
	private VaccineDAO vaccineDAO;

	public VerifyVaccineOTPServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean crated ");
	}

	@Override
	public boolean validateOTP(VaccineVerifyOTPDTO vaccineVerifyOTPDTO) {
		System.out.println("validateOTP() Invoked");
		boolean flag = false;
		if (!vaccineVerifyOTPDTO.getOtp().isEmpty() && !vaccineVerifyOTPDTO.getOtp().isBlank()
				&& vaccineVerifyOTPDTO != null) {
			flag = true;
			System.out.println("valid otp");
		} else {
			flag = false;
			System.out.println("Invalid otp ..enter correct 6 digit otp");
			return flag;
		}
		return flag;
	}

}