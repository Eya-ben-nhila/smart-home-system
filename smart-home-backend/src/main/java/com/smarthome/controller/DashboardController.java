package com.smarthome.controller;

import com.smarthome.service.DeviceService;
import com.smarthome.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        List<Device> allDevices = deviceService.getAllDevices();
        
        // Calculate statistics
        long totalDevices = allDevices.size();
        long activeDevices = allDevices.stream().filter(Device::isActive).count();
        long livingRoomDevices = allDevices.stream().filter(d -> "Living Room".equals(d.getRoom())).count();
        long kitchenDevices = allDevices.stream().filter(d -> "Kitchen".equals(d.getRoom())).count();
        
        // Temperature stats
        double avgTemp = allDevices.stream()
            .filter(d -> "thermostat".equals(d.getType()))
            .mapToDouble(Device::getCurrentTemp)
            .average()
            .orElse(22.0);
        
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalDevices", totalDevices);
        stats.put("activeDevices", activeDevices);
        stats.put("indoorTemp", (int) avgTemp);
        stats.put("outdoorTemp", 65);
        stats.put("humidity", 45);
        stats.put("livingRoomDevices", livingRoomDevices);
        stats.put("kitchenDevices", kitchenDevices);
        
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getDashboardDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/rooms")
    public ResponseEntity<Map<String, Object>> getRoomStats() {
        List<Device> allDevices = deviceService.getAllDevices();
        
        Map<String, Object> roomStats = new HashMap<>();
        roomStats.put("living", deviceService.getDevicesByRoom("Living Room"));
        roomStats.put("kitchen", deviceService.getDevicesByRoom("Kitchen"));
        roomStats.put("bedroom", deviceService.getDevicesByRoom("Bedroom"));
        roomStats.put("bathroom", deviceService.getDevicesByRoom("Bathroom"));
        
        return ResponseEntity.ok(roomStats);
    }
}
