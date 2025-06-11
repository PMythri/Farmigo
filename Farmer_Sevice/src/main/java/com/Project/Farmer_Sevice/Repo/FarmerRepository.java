package com.Project.Farmer_Sevice.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Farmer_Sevice.Model.Farmer;
@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

    boolean existsByFarmername(String farmername);
    
    Optional<Farmer> findByFarmername(String farmername);
    Farmer getByfarmername(String farmername);
}
