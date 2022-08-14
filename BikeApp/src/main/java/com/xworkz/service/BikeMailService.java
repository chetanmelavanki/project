package com.xworkz.service;

import com.xworkz.dto.BikeMailDTO;

public interface BikeMailService {
	boolean validateBikeMailDTO(BikeMailDTO bikeMailDTO);
	
	boolean sendEmail(BikeMailDTO bikeMailDTO);
}
