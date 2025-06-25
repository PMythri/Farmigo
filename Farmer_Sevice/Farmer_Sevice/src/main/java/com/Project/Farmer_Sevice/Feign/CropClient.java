package com.Project.Farmer_Sevice.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cropdeal.Crop.model.Crop;

import java.util.List;



@FeignClient(name = "crop-service", url = "http://localhost:9091/crop")
public interface CropClient {
	@GetMapping("/all")
    List<Crop> getAllCrops();

    @GetMapping("/{id}")
    Crop getCropById(@PathVariable int id);


}
