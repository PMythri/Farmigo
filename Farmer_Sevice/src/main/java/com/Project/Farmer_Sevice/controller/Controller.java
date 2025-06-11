package com.Project.Farmer_Sevice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Farmer_Sevice.Model.Farmer;
import com.Project.Farmer_Sevice.Service.FarmerService;
import com.Project.Farmer_Sevice.dto.Dto;

import com.cropdeal.Crop.model.Crop;
//import com.cropdeal.farmer.dto.FarmerDTO;
//import com.cropdeal.farmer.model.farmermodel;

@RestController
@RequestMapping("/Farmer")
public class Controller {
	@Autowired
	FarmerService service;
	
    @PostMapping("/register")
    public ResponseEntity<Farmer> registerFarmer(@RequestBody Farmer farmer) {
        return ResponseEntity.ok(service.addFarmer(farmer));
    }

    @PostMapping("/login")
    public String LoginFarmer(@RequestBody Dto dto) {
    	return service.LoginFarmer(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getFarmerProfile(@PathVariable int id) {
        try {
            Farmer farmer = service.getProfile(id);
            String response = "Farmer Found: " + farmer.getFarmername() + ", Email: " + farmer.getEmail() 
                    + ", Crops: " + farmer.getCrops();
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Error: " + e.getMessage()); // Return 404 for not found
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        return ResponseEntity.ok(service.getAllFarmers());
    }
//    @PostMapping("/addCrop")
//    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) {
//        return ResponseEntity.ok(service.save(crop));
//    }
    @GetMapping("/crops")
    public List<Crop> getAllCrops() {
        return service.getAllCropsFromCropService();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFarmer(@PathVariable int id, @RequestBody Farmer farmer) {
        try {
            Farmer updatedFarmer = service.updateFarmer(farmer, id);
            return ResponseEntity.ok(updatedFarmer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Error: " + e.getMessage()); 
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarmer(@PathVariable int id) {
        try {
            service.deleteFarmer(id);
            return ResponseEntity.ok("Farmer deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Error: " + e.getMessage());
        }
 

}}
