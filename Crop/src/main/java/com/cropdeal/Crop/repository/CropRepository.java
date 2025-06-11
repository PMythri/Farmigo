package com.cropdeal.Crop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.Crop.model.Crop;

import java.util.List;

@Repository

public interface CropRepository extends JpaRepository<Crop, Integer> {
	Crop findByName(String name);
 
}

