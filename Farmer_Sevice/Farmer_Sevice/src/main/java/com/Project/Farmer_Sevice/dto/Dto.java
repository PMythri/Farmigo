package com.Project.Farmer_Sevice.dto;

public class Dto {
	private String Farmername;
	private String password;
	public String getFarmername() {
		return Farmername;
	}
	public void setFarmername(String farmername) {
		Farmername = farmername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Dto(String farmername, String password) {
		super();
		Farmername = farmername;
		this.password = password;
	}
	public Dto() {
		super();
	}
	
	

}
