package com.Project.DealerService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Component;

import com.Project.DealerService.Dao.Dealerdao;
import com.Project.DealerService.Entity.Dealers;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private Dealerdao dao;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Dealers> dealerInfo = dao.findByUsername(username); // Ensure this matches the repository method

            return dealerInfo.map(UserInfoUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        }
    }

