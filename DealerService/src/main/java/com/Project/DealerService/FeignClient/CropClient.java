package com.Project.DealerService.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cropdeal.Crop.model.Crop;

import java.util.List;

@FeignClient(name = "crop-service", url = "http://localhost:9091/crop")
public interface CropClient {
	 @GetMapping("/all")
	    List<Crop> getAllCrops();
	 
	   @GetMapping("/name/{cropName}")
	    Crop getCropByName(@PathVariable String cropName);
	 @GetMapping("/getByIds")
	    List<Crop> getCropsByIds(@RequestBody List<Integer> cropIds);
	


}
