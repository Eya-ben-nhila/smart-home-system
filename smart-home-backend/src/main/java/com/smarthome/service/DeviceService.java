package com.smarthome.service;

import com.smarthome.model.Device;
import com.smarthome.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public List<Device> getDevicesByRoom(String room) {
        return deviceRepository.findByRoom(room);
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device updateDevice(Long id, Device deviceDetails) {
        Optional<Device> optionalDevice = deviceRepository.findById(id);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            device.setName(deviceDetails.getName());
            device.setType(deviceDetails.getType());
            device.setRoom(deviceDetails.getRoom());
            device.setStatus(deviceDetails.getStatus());
            device.setIntensity(deviceDetails.getIntensity());
            device.setCurrentTemp(deviceDetails.getCurrentTemp());
            device.setTargetTemp(deviceDetails.getTargetTemp());
            device.setMode(deviceDetails.getMode());
            device.setBatteryLevel(deviceDetails.getBatteryLevel());
            return deviceRepository.save(device);
        }
        return null;
    }

    public Device toggleDevice(Long id) {
        Optional<Device> optionalDevice = deviceRepository.findById(id);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            device.setActive(!device.isActive());
            return deviceRepository.save(device);
        }
        return null;
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    public void initializeSampleData() {
        // Living Room Devices
        deviceRepository.save(new Device("Living Room Lights", "light", "Living Room", "On"));
        deviceRepository.save(new Device("Living Room TV", "tv", "Living Room", "On"));
        deviceRepository.save(new Device("Main AC Unit", "thermostat", "Living Room", "On"));
        
        // Kitchen Devices
        deviceRepository.save(new Device("Smart Fridge", "fridge", "Kitchen", "On"));
        deviceRepository.save(new Device("Espresso Master", "coffee", "Kitchen", "Off"));
        deviceRepository.save(new Device("Counter Lights", "light", "Kitchen", "Off"));
        
        // Set some initial values
        List<Device> devices = deviceRepository.findAll();
        for (Device device : devices) {
            if ("thermostat".equals(device.getType())) {
                device.setCurrentTemp(22.0);
                device.setTargetTemp(20.5);
                device.setMode("Heating");
            } else if ("light".equals(device.getType())) {
                device.setIntensity(75);
            } else if ("tv".equals(device.getType())) {
                device.setIntensity(50);
            }
            deviceRepository.save(device);
        }
    }
}
