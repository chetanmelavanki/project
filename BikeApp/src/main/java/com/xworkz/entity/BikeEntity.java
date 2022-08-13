package com.xworkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "bike_table")
@NamedQuery(name = "BikeEntity.findBikeEntity", query = "from BikeEntity where bikeName=:BIKENAME")
@NamedQuery(name = "BikeEntity.getAllBike",query = "from BikeEntity")
@NamedQuery(name = "BikeEntity.deleteBikeByName",query = "delete from BikeEntity where bikeName=:DELETEBIKE")
@NamedQuery(name = "BikeEntity.updateBikeByBikeName", query = "update BikeEntity set bikeName=:BIKENAME, bikeColor=:BIKECOLOR,bikeBrand=:BIKEBRAND,bikeCost=:BIKECOST,bikeType=:BIKETYPE where bikeName=:BIKENAME")
public class BikeEntity {
	@Id
	@Column(name = "bike_id")
	@GenericGenerator(name = "x",strategy = "increment")
	@GeneratedValue(generator = "x")
	private int id;
	@Column(name = "bike_name")
	private String bikeName;
	@Column(name = "bike_color")
	private String bikeColor;
	@Column(name = "bike_brand")
	private String bikeBrand;
	@Column(name = "bike_cost")
	private double bikeCost;
	@Column(name = "bike_type")
	private String bikeType;
	
	public BikeEntity() {
		System.out.println(this.getClass().getSimpleName()+"Invoked");
	}

	public BikeEntity(String bikeName, String bikeColor, String bikeBrand, double bikeCost, String bikeType) {
		super();
		this.bikeName = bikeName;
		this.bikeColor = bikeColor;
		this.bikeBrand = bikeBrand;
		this.bikeCost = bikeCost;
		this.bikeType = bikeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "BikeEntity [id=" + id + ", bikeName=" + bikeName + ", bikeColor=" + bikeColor + ", bikeBrand="
				+ bikeBrand + ", bikeCost=" + bikeCost + ", bikeType=" + bikeType + "]";
	}
	
	
}
