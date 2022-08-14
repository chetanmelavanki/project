package com.xworkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "vaccine_table")
public class VaccineEntity {

	@Id
	@Column(name = "vaccine_otp_id")
	@GenericGenerator(name = "x", strategy = "increment")
	@GeneratedValue(generator = "x")
	private int id;

	@Column(name = "vaccine_otp")
	private String otp;

	public VaccineEntity() {
		System.out.println(this.getClass().getSimpleName() + " Bean crated ");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "VaccineEntity [id=" + id + ", otp=" + otp + "]";
	}

}
