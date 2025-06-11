package com.Project.DealerService.Entity;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dealers")
public class Dealers{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String businessName;
    private String role;
    @ElementCollection
    private List<String> selectedCrops;
    private Double totalPrice;

    public List<String> getSelectedCrops() {
        return selectedCrops;
    }

    public void setSelectedCrops(List<String> selectedCrops) {
        this.selectedCrops = selectedCrops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Dealers(int id, String username, String password, String phoneNumber, String email, String businessName,
			String role, List<String> selectedCrops, Double totalPrice) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.businessName = businessName;
		this.role = role;
		this.selectedCrops = selectedCrops;
		this.totalPrice = totalPrice;
	}

	public Dealers() {
		super();
		// TODO Auto-generated constructor stub
	}

	}