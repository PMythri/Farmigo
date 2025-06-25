package com.Project.Farmer_Sevice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FarmersData")
public class Farmer {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String farmername;
	private String password;
	private String email;
	private String BankAccountNo;
	private String IFSC;
	private String Crops;
	private String location;
	private String role;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFarmername() {
		return farmername;
	}
	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBankAccountNo() {
		return BankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		BankAccountNo = bankAccountNo;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getCrops() {
		return Crops;
	}
	public void setCrops(String crops) {
		Crops = crops;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Farmer(int id, String farmername, String password, String email, String bankAccountNo, String iFSC,
			String crops, String location, String role) {
		super();
		Id = id;
		this.farmername = farmername;
		this.password = password;
		this.email = email;
		BankAccountNo = bankAccountNo;
		IFSC = iFSC;
		Crops = crops;
		this.location = location;
		this.role = role;
	}

	public Farmer() {
		super();
	}
	
	
	

}
