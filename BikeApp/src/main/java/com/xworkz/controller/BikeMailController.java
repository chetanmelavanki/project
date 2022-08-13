package com.xworkz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.dto.BikeMailDTO;
import com.xworkz.service.BikeMailService;

@RequestMapping("/")
@Controller
public class BikeMailController {

	@Autowired
	private BikeMailService bikeMailService;

	public BikeMailController() {
		System.out.println(this.getClass().getSimpleName() + "bean created");
	}

	@RequestMapping("/getResourcesLinks.bike")
	public String getResourceLinks() {
		System.out.println("getResources() Invoked");
		return "welcome";
	}

	@RequestMapping(value = "/getMailResource.bike")
	public String getMailResource() {
		System.out.println("getMailResource() Invoked");
		return "mail";
	}

	@RequestMapping(value = "/readEmailDetails.bike", method = RequestMethod.POST)
	public String readMailDetails(@ModelAttribute BikeMailDTO bikeMailDTO, Model model) {
		System.out.println("readMailDetails() Invoked");
		System.out.println(bikeMailDTO);
		boolean validateMail = this.bikeMailService.validateBikeMailDTO(bikeMailDTO);
		if (validateMail) {
			System.out.println("valid mail datails");
			boolean isMailSent = this.bikeMailService.sendEmail(bikeMailDTO);
			if (isMailSent) {
				System.out.println("Email is sent...");
				model.addAttribute("errorMail", "Email is sent...");
			} else {
				System.out.println("Email not sent..Something went try again");
				model.addAttribute("errorMail", "Email not sent..Something went try again");
			}
		} else {
			System.out.println("invalid mail details");
		}

		return "mail";
	}
}
