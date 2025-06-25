package com.Project.Farmer_Sevice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Project.Farmer_Sevice.Feign.CropClient;
import com.Project.Farmer_Sevice.Model.Farmer;
import com.Project.Farmer_Sevice.Repo.FarmerRepository;
import com.Project.Farmer_Sevice.dto.Dto;
import com.cropdeal.Crop.model.Crop;
@Service
public class FarmerService {

	@Autowired
	FarmerRepository dao;
	
	@Autowired
    private CropClient cropClient;

	@Autowired
	JwtService service;
    @Autowired
    private PasswordEncoder passwordEncoder;
	public Farmer addFarmer(Farmer farmer) {
		// TODO Auto-generated method stub
		if (dao.existsByFarmername(farmer.getFarmername())) {
            throw new RuntimeException("Farmer name already exists!");
        }
		farmer.setPassword(passwordEncoder.encode(farmer.getPassword()));
        return dao.save(farmer);
//dao.save(farmer);
	//return "Farmer Saved";
	}
//    public String addUser(UserInfo userInfo) {
//    	
//        repository.save(userInfo);
//        return "User added successfully!";
//    }
	public Farmer getProfile(int id) {
		// TODO Auto-generated method stub
		 return dao.findById(id)
	                .orElseThrow(() -> new RuntimeException("Farmer not found with ID: " + id));
	}
    public List<Farmer> getAllFarmers() {
        return dao.findAll();
    }
    public Farmer updateFarmer(Farmer farmer, int id) {
        Optional<Farmer> existingFarmer = dao.findById(id);
        if (existingFarmer.isEmpty()) {
            throw new RuntimeException("Farmer not found with ID: " + id);
        }

        Farmer foundFarmer = existingFarmer.get();
        foundFarmer.setFarmername(farmer.getFarmername());
        foundFarmer.setEmail(farmer.getEmail());
        foundFarmer.setBankAccountNo(farmer.getBankAccountNo());
        foundFarmer.setIFSC(farmer.getIFSC());
        foundFarmer.setCrops(farmer.getCrops());
        foundFarmer.setLocation(farmer.getLocation());

        return dao.save(foundFarmer);
    }
    public String deleteFarmer(int id) {
        if (!dao.existsById(id)) {
            throw new RuntimeException("Farmer not found with ID: " + id);
        }
        dao.deleteById(id);
        return "Farmer deleted successfully!";
    }
    
    public List<Crop> getAllCropsFromCropService() {
        return cropClient.getAllCrops();
    }
	public String LoginFarmer(Dto dto) {
		boolean flag = dao.existsByFarmername(dto.getFarmername());
		if(flag) {
			Farmer farmer =  dao.getByfarmername(dto.getFarmername());
			String token  = service.generateToken(farmer.getFarmername(), farmer.getRole());
			return token;
			
		}
		else {
			return "User name not found";
		}
	}



 }
