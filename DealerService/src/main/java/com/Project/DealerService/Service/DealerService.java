package com.Project.DealerService.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Project.DealerService.Dao.Dealerdao;
import com.Project.DealerService.Entity.Dealers;
import com.Project.DealerService.FeignClient.CartClient;
import com.Project.DealerService.FeignClient.CropClient;
import com.Project.DealerService.dto.CartDto;
import com.Project.DealerService.dto.DealerDto;
import com.cropdeal.Crop.model.Crop;

@Service
public class DealerService {

    @Autowired
    Dealerdao dao;

    @Autowired
    private CropClient cropClient;

    @Autowired
    private CartClient cartClient;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Dealers addDealer(Dealers dealer) {
        if (dao.existsByUsername(dealer.getUsername())) {
            throw new RuntimeException("Dealer username already exists!");
        }
        dealer.setPassword(passwordEncoder.encode(dealer.getPassword()));
        return dao.save(dealer);
    }

    public Dealers getDealerById(int id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("Dealer not found with ID: " + id));
    }

    public List<Dealers> getAllDealers() {
        return dao.findAll();
    }

    public String addCropsToCart(int dealerId, List<String> cropNames) {
        Dealers dealer = dao.findById(dealerId).orElseThrow(() -> new RuntimeException("Dealer not found"));

        List<Crop> selectedCrops = cropNames.stream()
                .map(cropClient::getCropByName)
                .collect(Collectors.toList());

        double totalPrice = selectedCrops.stream().mapToDouble(Crop::getPrice).sum();

        CartDto cartDto = new CartDto();
        cartDto.setUserId(dealerId);
        cartDto.setSelectedCrops(selectedCrops.stream().map(Crop::getName).collect(Collectors.toList()));
        cartDto.setCropTypes(selectedCrops.stream().map(Crop::getType).collect(Collectors.toList()));
        cartDto.setCropSeasons(selectedCrops.stream().map(Crop::getSeason).collect(Collectors.toList()));
        cartDto.setTotalPrice(totalPrice);

        return cartClient.addToCart(cartDto);
    }

    public List<Crop> getAvailableCrops() {
        return cropClient.getAllCrops();
    }

    public String loginDealer(DealerDto dto) {
        boolean flag = dao.existsByUsername(dto.getUsername());
        if (flag) {
            Dealers dealer = dao.getByUsername(dto.getUsername());
            if (dealer != null) {
                return "Login successful!";
            } else {
                return "Dealer details not found";
            }
        } else {
            return "Username not found";
        }
    }
}