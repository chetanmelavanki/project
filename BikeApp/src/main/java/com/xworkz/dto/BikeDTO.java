package com.xworkz.dto;

public class BikeDTO {
	private String bikeName;
	private String bikeColor;
	private String bikeBrand;
	private double bikeCost;
	private String bikeType;
	
	public BikeDTO() {
		System.out.println(this.getClass().getSimpleName()+" Invoked");
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getBikeColor() {
		return bikeColor;
	}

	public void setBikeColor(String bikeColor) {
		this.bikeColor = bikeColor;
	}

	public String getBikeBrand() {
		return bikeBrand;
	}

	public void setBikeBrand(String bikeBrand) {
		this.bikeBrand = bikeBrand;
	}

	public double getBikeCost() {
		return bikeCost;
	}

	public void setBikeCost(double bikeCost) {
		this.bikeCost = bikeCost;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
	
	
}
