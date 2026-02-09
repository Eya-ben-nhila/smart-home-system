package com.smarthome.config;

import com.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private DeviceService deviceService;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            deviceService.initializeSampleData();
        };
    }
}
