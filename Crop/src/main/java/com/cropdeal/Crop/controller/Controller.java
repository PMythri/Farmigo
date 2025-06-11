package com.cropdeal.Crop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cropdeal.Crop.model.Crop;
import com.cropdeal.Crop.service.CropService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crop")
public class Controller {

    @Autowired
    private CropService cropService;

    // Add a new crop
    @PostMapping("/add")
    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) {
        try {
            return ResponseEntity.ok(cropService.addCrop(crop));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @GetMapping("/name/{cropName}")
    public ResponseEntity<Crop> getCropByName(@PathVariable String cropName) {
        return ResponseEntity.ok(cropService.getCropByName(cropName));
    }
    // Get all crops
    @GetMapping("/all")
    public ResponseEntity<List<Crop>> getAllCrops() {
        return ResponseEntity.ok(cropService.getAllCrops());
    }

    // Update crop details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCrop(@PathVariable int id, @RequestBody Crop cropDetails) {
        try {
            Crop updatedCrop = cropService.updateCrop(id, cropDetails);
            return ResponseEntity.ok(updatedCrop);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Error: " + e.getMessage());
        }
    }
    // Delete a crop
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrop(@PathVariable int id) {
        try {
            cropService.deleteCrop(id);
            return ResponseEntity.ok("Crop deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Error: " + e.getMessage());
        }
    }
}