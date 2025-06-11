package com.Project.DealerService.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.DealerService.Entity.Dealers;

@Repository
public interface Dealerdao extends JpaRepository<Dealers, Integer>{

	boolean existsByUsername(String username);

    Optional<Dealers> findByUsername(String username);

    Dealers getByUsername(String username);
}
