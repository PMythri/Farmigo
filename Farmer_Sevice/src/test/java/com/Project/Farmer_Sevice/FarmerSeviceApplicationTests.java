package com.Project.Farmer_Sevice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Project.Farmer_Sevice.Model.Farmer;
import com.Project.Farmer_Sevice.Repo.FarmerRepository;
import com.Project.Farmer_Sevice.Service.FarmerService;
import com.Project.Farmer_Sevice.Feign.CropClient;
import com.Project.Farmer_Sevice.dto.Dto;
import com.cropdeal.Crop.model.Crop;

public class FarmerSeviceApplicationTests {

    @Mock
    private FarmerRepository dao;

    @InjectMocks
    private FarmerService farmerService;

    private Farmer mockFarmer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockFarmer = new Farmer(1, "John Doe", "password123", "john@example.com", "1234567890", "IFSC001", "Wheat", "Location A", "Farmer");
    }

    @Test
    void testAddFarmer() {
        when(dao.existsByFarmername(mockFarmer.getFarmername())).thenReturn(false);
        when(dao.save(any(Farmer.class))).thenReturn(mockFarmer);

        Farmer savedFarmer = farmerService.addFarmer(mockFarmer);

        assertNotNull(savedFarmer);
        assertEquals("John Doe", savedFarmer.getFarmername());
        verify(dao, times(1)).save(mockFarmer);
    }

    @Test
    void testGetProfile() {
        when(dao.findById(1)).thenReturn(Optional.of(mockFarmer));

        Farmer foundFarmer = farmerService.getProfile(1);

        assertEquals("John Doe", foundFarmer.getFarmername());
        verify(dao, times(1)).findById(1);
    }

    @Test
    void testUpdateFarmer() {
        when(dao.findById(1)).thenReturn(Optional.of(mockFarmer));
        when(dao.save(any(Farmer.class))).thenReturn(mockFarmer);

        Farmer updatedFarmer = farmerService.updateFarmer(mockFarmer, 1);

        assertEquals("John Doe", updatedFarmer.getFarmername());
        verify(dao, times(1)).save(mockFarmer);
    }

    @Test
    void testDeleteFarmer() {
        when(dao.existsById(1)).thenReturn(true);
        doNothing().when(dao).deleteById(1);

        String response = farmerService.deleteFarmer(1);

        assertEquals("Farmer deleted successfully!", response);
        verify(dao, times(1)).deleteById(1);
    }

    @Test
    void testGetAllFarmers() {
        when(dao.findAll()).thenReturn(List.of(mockFarmer));

        List<Farmer> farmers = farmerService.getAllFarmers();

        assertEquals(1, farmers.size());
        verify(dao, times(1)).findAll();
    }

    
}
