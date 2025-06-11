package com.Project.DealerService.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project.DealerService.Entity.Dealers;
import com.Project.DealerService.Service.DealerService;
import com.Project.DealerService.dto.DealerDto;
import com.cropdeal.Crop.model.Crop;

@RestController
@RequestMapping("/Dealer")
public class Controller {

    @Autowired
    DealerService service;

    @PostMapping("/register")
    public ResponseEntity<Dealers> registerDealer(@RequestBody Dealers dealer) {
        return ResponseEntity.ok(service.addDealer(dealer));
    }

    @PostMapping("/login")
    public String loginDealer(@RequestBody DealerDto dto) {
        return service.loginDealer(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealers> getDealerById(@PathVariable int id) {
        return ResponseEntity.ok(service.getDealerById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dealers>> getAllDealers() {
        return ResponseEntity.ok(service.getAllDealers());
    }

    @GetMapping("/availableCrops")
    public ResponseEntity<List<Crop>> fetchAllCrops() {
        return ResponseEntity.ok(service.getAvailableCrops());
    }

    @PostMapping("/addToCart/{dealerId}")
    public ResponseEntity<String> addCropsToCart(@PathVariable int dealerId, @RequestBody List<String> cropNames) {
        return ResponseEntity.ok(service.addCropsToCart(dealerId, cropNames));
    }
}