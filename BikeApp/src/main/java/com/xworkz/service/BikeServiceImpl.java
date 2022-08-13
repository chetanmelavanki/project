package com.xworkz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xworkz.DAO.BikeDAO;
import com.xworkz.dto.BikeDTO;
import com.xworkz.entity.BikeEntity;

@Service
public class BikeServiceImpl implements BikeService {

	public static Map<String, String> map = new HashMap<>();

	@Autowired
	private BikeDAO bikeDAO;
	
	private static BikeEntity bikeEntity=null;

	public BikeServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "Invoked");
	}

	@Override
	public boolean validateBike(BikeDTO bikeDTO) {
		boolean flag = false;
		if (bikeDTO.getBikeName() != null && !bikeDTO.getBikeName().isBlank() && !bikeDTO.getBikeName().isEmpty()) {
			flag = true;
			System.out.println("bike name is valid");
		} else {
			flag = false;
			System.out.println("bike name is invalid");
			// error messgaea to print in ui
			map.put("bikeName", "bike name is invalid");
			return flag;
		}
		if (bikeDTO.getBikeColor() != null && !bikeDTO.getBikeColor().isBlank() && !bikeDTO.getBikeColor().isEmpty()) {
			flag = true;
			System.out.println("bike color is valid");
		} else {
			flag = false;
			System.out.println("bike color is invalid");
			map.put("bikeColor", "bike color is invalid");
			return flag;
		}
		if (bikeDTO.getBikeBrand() != null && !bikeDTO.getBikeBrand().isBlank() && !bikeDTO.getBikeBrand().isEmpty()) {
			flag = true;
			System.out.println("bike brand is valid");
		} else {
			flag = false;
			System.out.println("bike brand is invalid");
			map.put("bikeBrand", "bike brand is invalid");
			return flag;
		}
		if (bikeDTO.getBikeCost() > 50000) {
			flag = true;
			System.out.println("bike cost is valid");
		} else {
			flag = false;
			System.out.println("bike cost is invalid");
			map.put("bikeCost", "bike cost is invalid");
			return flag;
		}

		if (bikeDTO.getBikeType() != null && !bikeDTO.getBikeType().isBlank() && !bikeDTO.getBikeType().isEmpty()) {
			flag = true;
			System.out.println("bike type is valid");
		} else {
			flag = false;
			System.out.println("bike type is invalid");
			map.put("bikeType", "bike type is invalid");
			return flag;
		}
		return flag;
	}

	@Override
	public boolean saveData(BikeDTO bikeDTO) {
		System.out.println("saveData Invoked");

		bikeEntity = new BikeEntity();
		BeanUtils.copyProperties(bikeDTO, bikeEntity);
		boolean isBikeEntitySaved = this.bikeDAO.saveBikeEntity(bikeEntity);
		return isBikeEntitySaved;
	}

	@Override
	public boolean validateBikeName(String bikeName) {
		System.out.println("validateBikeName invoked");
		try {
			System.out.println("enter into try block");
			if (!bikeName.isEmpty() && !bikeName.isBlank() && bikeName != null) {
				System.out.println("valid bike  name");
			} else {
				System.out.println("invalid bike name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public BikeDTO getDTOByBikeName(String bikename) {
		System.out.println("getDTOByBikeName Invoked");
		BikeDTO bikeDTO = null;
		BikeEntity bikeEntity = this.bikeDAO.findBikeEntity(bikename);
		if (bikeEntity != null) {
			bikeDTO = new BikeDTO();
			BeanUtils.copyProperties(bikeEntity, bikeDTO);
		}
		return bikeDTO;
	}

	@Override
	public List<Object> getListOfBikeObject() {
		List<Object> list1 = null;
		List<BikeEntity> list = this.bikeDAO.getListOfBikeEntity();
		if (list != null) {
			list1 = new ArrayList<>();
			for (BikeEntity bikeEntity : list) {
				list1.add(bikeEntity);
				System.out.println(bikeEntity.toString());
			}
		} 
		return list1;
	}

	@Override
	public boolean deleteBikeByName(String bikeName) {
		System.out.println("deleteBikeByName Invoked in Service");
		boolean validate= this.bikeDAO.deleteBikeByName(bikeName);
		return false;
	}

	@Override
	public boolean updateBikeByBikeName(BikeDTO bikeDTO) {
		System.out.println("updateBikeByBikeName Invoked");
		BeanUtils.copyProperties(bikeDTO, bikeEntity);

		return this.bikeDAO.updateBikeByBikeName(bikeEntity);
	}	

}
