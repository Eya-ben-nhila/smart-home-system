package com.smarthome.model;

import jakarta.persistence.*;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private String room;
    
    @Column(nullable = false)
    private String status;
    
    @Column
    private boolean isActive;
    
    @Column
    private int intensity;
    
    @Column
    private double currentTemp;
    
    @Column
    private double targetTemp;
    
    @Column
    private String mode;
    
    @Column
    private int batteryLevel;
    
    // Constructors
    public Device() {}
    
    public Device(String name, String type, String room, String status) {
        this.name = name;
        this.type = type;
        this.room = room;
        this.status = status;
        this.isActive = "On".equals(status);
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status; 
        this.isActive = "On".equals(status);
    }
    
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { 
        this.isActive = active; 
        this.status = active ? "On" : "Off";
    }
    
    public int getIntensity() { return intensity; }
    public void setIntensity(int intensity) { this.intensity = intensity; }
    
    public double getCurrentTemp() { return currentTemp; }
    public void setCurrentTemp(double currentTemp) { this.currentTemp = currentTemp; }
    
    public double getTargetTemp() { return targetTemp; }
    public void setTargetTemp(double targetTemp) { this.targetTemp = targetTemp; }
    
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
    
    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) { this.batteryLevel = batteryLevel; }
}
