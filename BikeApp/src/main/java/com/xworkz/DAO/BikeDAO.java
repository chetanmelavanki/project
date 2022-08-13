package com.xworkz.DAO;

import java.util.List;

import com.xworkz.entity.BikeEntity;

public interface BikeDAO {

	public boolean saveBikeEntity(BikeEntity bikeEntity);

	public BikeEntity findBikeEntity(String bikename);

	public List<BikeEntity> getListOfBikeEntity();

	public boolean deleteBikeByName(String bikeName);

	public boolean updateBikeByBikeName(BikeEntity bikeEntity);

}
