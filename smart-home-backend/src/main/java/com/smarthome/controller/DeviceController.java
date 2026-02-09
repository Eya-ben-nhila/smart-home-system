package com.smarthome.controller;

import com.smarthome.model.Device;
import com.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        if (device != null) {
            return ResponseEntity.ok(device);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/room/{room}")
    public ResponseEntity<List<Device>> getDevicesByRoom(@PathVariable String room) {
        return ResponseEntity.ok(deviceService.getDevicesByRoom(room));
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device createdDevice = deviceService.createDevice(device);
        return ResponseEntity.ok(createdDevice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device) {
        Device updatedDevice = deviceService.updateDevice(id, device);
        if (updatedDevice != null) {
            return ResponseEntity.ok(updatedDevice);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/toggle")
    public ResponseEntity<Device> toggleDevice(@PathVariable Long id) {
        Device device = deviceService.toggleDevice(id);
        if (device != null) {
            return ResponseEntity.ok(device);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.ok().build();
    }
}
