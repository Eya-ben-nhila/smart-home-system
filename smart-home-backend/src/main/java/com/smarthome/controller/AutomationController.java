package com.smarthome.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/automations")
@CrossOrigin(origins = "http://localhost:4200")
public class AutomationController {

    @GetMapping("/scenes")
    public ResponseEntity<List<Map<String, Object>>> getScenes() {
        List<Map<String, Object>> scenes = new ArrayList<>();
        
        scenes.add(createScene(1L, "Morning Routine", 
            "Gradually wake up with lights, open blinds, start coffee maker", 
            "wb_twilight", "orange", true, "6:30 AM", 5));
        
        scenes.add(createScene(2L, "Good Night", 
            "Dim lights, lock doors, arm security system", 
            "bedtime", "indigo", false, "10:30 PM", 8));
        
        scenes.add(createScene(3L, "Movie Night", 
            "Dim living room lights, close blinds, set temperature", 
            "movie", "primary", false, "Manual", 3));
        
        scenes.add(createScene(4L, "Away Mode", 
            "Turn off lights, arm security, adjust thermostat", 
            "directions_walk", "red", false, "Geofence", 12));
        
        return ResponseEntity.ok(scenes);
    }

    @GetMapping("/automations")
    public ResponseEntity<List<Map<String, Object>>> getAutomations() {
        List<Map<String, Object>> automations = new ArrayList<>();
        
        automations.add(createAutomation(1L, "Motion-Activated Lights", "Motion detected", "Turn on hallway lights", true, "sensors"));
        automations.add(createAutomation(2L, "Temperature Control", "Temperature > 75°F", "Turn on AC", true, "thermostat"));
        automations.add(createAutomation(3L, "Door Lock Alert", "Front door unlocked", "Send notification", false, "lock"));
        
        return ResponseEntity.ok(automations);
    }

    @PostMapping("/scenes/{id}/toggle")
    public ResponseEntity<Map<String, Object>> toggleScene(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Scene toggled successfully");
        response.put("sceneId", id);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/automations/{id}/toggle")
    public ResponseEntity<Map<String, Object>> toggleAutomation(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Automation toggled successfully");
        response.put("automationId", id);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/scenes")
    public ResponseEntity<Map<String, Object>> createScene(@RequestBody Map<String, Object> sceneData) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Scene created successfully");
        response.put("sceneId", System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/automations")
    public ResponseEntity<Map<String, Object>> createAutomation(@RequestBody Map<String, Object> automationData) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Automation created successfully");
        response.put("automationId", System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }

    private Map<String, Object> createScene(Long id, String name, String description, String icon, String color, boolean active, String schedule, int devices) {
        Map<String, Object> scene = new HashMap<>();
        scene.put("id", id);
        scene.put("name", name);
        scene.put("description", description);
        scene.put("icon", icon);
        scene.put("color", color);
        scene.put("active", active);
        scene.put("schedule", schedule);
        scene.put("devices", devices);
        return scene;
    }

    private Map<String, Object> createAutomation(Long id, String name, String trigger, String action, boolean active, String icon) {
        Map<String, Object> automation = new HashMap<>();
        automation.put("id", id);
        automation.put("name", name);
        automation.put("trigger", trigger);
        automation.put("action", action);
        automation.put("active", active);
        automation.put("icon", icon);
        return automation;
    }
}
