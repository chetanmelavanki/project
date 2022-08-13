package com.xworkz.service;

import java.util.List;

import com.xworkz.dto.BikeDTO;

public interface BikeService {

	public boolean validateBike(BikeDTO bikeDTO);

	public boolean saveData(BikeDTO bikeDTO);

	public boolean validateBikeName(String bikeName);

	public BikeDTO getDTOByBikeName(String bikeName);

	public List<Object> getListOfBikeObject();

	public boolean deleteBikeByName(String bikeName);

	public boolean updateBikeByBikeName(BikeDTO bikeDTO);

	
}
