package com.Project.Farmer_Sevice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Project.Farmer_Sevice.Model.Farmer;
import com.Project.Farmer_Sevice.Repo.FarmerRepository;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private FarmerRepository repository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Farmer> farmerinfo = repository.findByFarmername(username); // Ensure this matches the repository method

            return farmerinfo.map(UserInfoUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        }
    }
