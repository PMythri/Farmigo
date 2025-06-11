package com.cropdeal.Crop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.Crop.model.Crop;
import com.cropdeal.Crop.repository.CropRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }
    public Crop getCropByName(String name) {
        return cropRepository.findByName(name);
    }

    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public Crop updateCrop(int id, Crop cropDetails) {
        return cropRepository.findById(id)
                .map(crop -> {
                    crop.setName(cropDetails.getName());
                    crop.setType(cropDetails.getType());
                    crop.setPrice(cropDetails.getPrice());
                    crop.setSeason(cropDetails.getSeason());
                    return cropRepository.save(crop);
                }).orElseThrow(() -> new RuntimeException("Crop not found!"));
    }

    public void deleteCrop(int id) {
        cropRepository.deleteById(id);
    }
}