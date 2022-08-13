package com.xworkz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.dto.BikeMailDTO;

@Service
public class BikeMailServiceImpl implements BikeMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public BikeMailServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "bean created");
	}

	@Override
	public boolean validateBikeMailDTO(BikeMailDTO bikeMailDTO) {
		boolean flag = false;

		if (!bikeMailDTO.getToEmail().isEmpty() && !bikeMailDTO.getToEmail().isBlank()
				&& bikeMailDTO.getToEmail() != null) {
			flag = true;
			System.out.println("To mail Id is Valid");
		} else {
			flag = false;
			System.out.println("To mail Id is Valid not valid");
			return flag;
		}

		if (!bikeMailDTO.getSubject().isEmpty() && !bikeMailDTO.getSubject().isBlank()
				&& bikeMailDTO.getSubject() != null) {
			flag = true;
			System.out.println("Subject of mail Id is Valid");
		} else {
			flag = false;
			System.out.println("Subject of mail Id is Valid not valid");
			return flag;
		}
		
		if (!bikeMailDTO.getTextBody().isEmpty() && !bikeMailDTO.getTextBody().isBlank()
				&& bikeMailDTO.getTextBody() != null) {
			flag = true;
			System.out.println("text body of mail Id is Valid");
		} else {
			flag = false;
			System.out.println("text body of mail Id is Valid not valid");
			return flag;
		}

		return flag;
	}

	@Override
	public boolean sendEmail(BikeMailDTO bikeMailDTO) {
		boolean flag = false;
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(bikeMailDTO.getToEmail());
			mailMessage.setFrom("Chetanmelavanki@outlook.com");
			mailMessage.setSubject(bikeMailDTO.getSubject());
			mailMessage.setText(bikeMailDTO.getTextBody());
			this.javaMailSender.send(mailMessage);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
