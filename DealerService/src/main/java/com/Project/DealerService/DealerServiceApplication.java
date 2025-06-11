package com.Project.DealerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DealerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealerServiceApplication.class, args);
    }
}
