package com.smarthome.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "http://localhost:4200")
public class AlertController {

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllAlerts() {
        List<Map<String, Object>> alerts = new ArrayList<>();
        
        // Critical Alerts
        alerts.add(createAlert(1L, "Motion Detected - Backyard", 
            "High-intensity motion detected by the Rear Terrace Camera. Person identified near the perimeter.", 
            "2 mins ago", "emergency_home", "critical"));
        
        alerts.add(createAlert(2L, "CO Detector Alert - Kitchen", 
            "Carbon Monoxide levels rising. Air purifier has been set to maximum.", 
            "12 mins ago", "detector_smoke", "critical"));
        
        // Warning Alerts
        alerts.add(createAlert(3L, "Low Battery - Front Door Lock", 
            "Battery level is at 8%. Please replace CR123A batteries soon to avoid lockout.", 
            "1 hour ago", "battery_alert", "warning"));
        
        alerts.add(createAlert(4L, "Device Offline - Garage Thermostat", 
            "Connection lost. This may be due to a local Wi-Fi outage or device power failure.", 
            "3 hours ago", "cloud_off", "warning"));
        
        // Info Alerts
        alerts.add(createAlert(5L, "Vacuuming Completed", 
            "\"Dusty\" has finished cleaning the First Floor and is returning to base. 120m² covered.", 
            "5 hours ago", "cleaning_services", "info"));
        
        alerts.add(createAlert(6L, "Smart Watering Active", 
            "Scheduled watering started for Zone 2 (Flower beds) based on local soil moisture.", 
            "6 hours ago", "sprinkler", "info"));
        
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getAlertSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("critical", 2);
        summary.put("warnings", 4);
        summary.put("info", 6);
        summary.put("securityScore", 85);
        return ResponseEntity.ok(summary);
    }

    @PostMapping("/{id}/dismiss")
    public ResponseEntity<Void> dismissAlert(@PathVariable Long id) {
        // In a real application, this would mark the alert as dismissed in the database
        return ResponseEntity.ok().build();
    }

    private Map<String, Object> createAlert(Long id, String title, String description, String time, String icon, String type) {
        Map<String, Object> alert = new HashMap<>();
        alert.put("id", id);
        alert.put("title", title);
        alert.put("description", description);
        alert.put("time", time);
        alert.put("icon", icon);
        alert.put("type", type);
        alert.put("timestamp", LocalDateTime.now().toString());
        
        List<String> actions = new ArrayList<>();
        if ("critical".equals(type)) {
            actions.add("View Live Feed");
            actions.add("Dismiss");
        } else if ("warning".equals(type)) {
            actions.add("Troubleshoot");
        } else if ("info".equals(type)) {
            actions.add("View Report");
        }
        alert.put("actions", actions);
        
        return alert;
    }
}
