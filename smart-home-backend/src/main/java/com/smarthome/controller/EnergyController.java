package com.smarthome.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/energy")
@CrossOrigin(origins = "http://localhost:4200")
public class EnergyController {

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getEnergyStats() {
        Map<String, Object> stats = new HashMap<>();
        
        // Current Load Stats
        stats.put("currentLoad", 2.41);
        stats.put("voltage", 230.1);
        stats.put("batteryLevel", 88.0);
        
        // Cost Savings
        stats.put("costSavings", 142.80);
        stats.put("solarPercentage", 72);
        stats.put("solarGeneration", 12.4);
        stats.put("gridLoad", 4.8);
        
        // Weekly Data
        List<Map<String, Object>> weeklyData = Arrays.asList(
            createDayData("Mon", 2.5, 3.2),
            createDayData("Tue", 3.8, 2.9),
            createDayData("Wed", 4.2, 2.5),
            createDayData("Thu", 5.1, 2.1),
            createDayData("Fri", 4.8, 2.3),
            createDayData("Sat", 3.2, 2.8),
            createDayData("Sun", 2.1, 3.5)
        );
        stats.put("weeklyData", weeklyData);
        
        // Efficiency Tips
        List<Map<String, Object>> efficiencyTips = Arrays.asList(
            createTip("schedule", "Shift Heavy Loads", 
                "Run dishwasher between 1 PM and 3 PM to utilize peak solar generation."),
            createTip("thermostat", "HVAC Optimization", 
                "Pre-cool home by 2°F while solar battery is full (80%+)."),
            createTip("power_settings_new", "Vampire Loads", 
                "Entertainment center detected as active while not in use. Enable Eco-Sleep?")
        );
        stats.put("efficiencyTips", efficiencyTips);
        
        // Quick Stats
        List<Map<String, Object>> quickStats = Arrays.asList(
            createQuickStat("eco", "Carbon Offset", "124.5 kg"),
            createQuickStat("battery_charging_full", "Battery Health", "98.2%"),
            createQuickStat("solar_power", "Efficiency Score", "88/100"),
            createQuickStat("energy_savings_leaf", "Trees Equivalent", "6.2")
        );
        stats.put("quickStats", quickStats);
        
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/usage")
    public ResponseEntity<Map<String, Object>> getUsageData(@RequestParam(defaultValue = "weekly") String period) {
        Map<String, Object> usage = new HashMap<>();
        
        if ("daily".equals(period)) {
            usage.put("labels", Arrays.asList("12AM", "4AM", "8AM", "12PM", "4PM", "8PM"));
            usage.put("solar", Arrays.asList(0.5, 0.8, 2.1, 4.5, 3.2, 1.8));
            usage.put("grid", Arrays.asList(1.2, 1.0, 2.5, 3.8, 4.2, 2.8));
        } else if ("monthly".equals(period)) {
            usage.put("labels", Arrays.asList("Week 1", "Week 2", "Week 3", "Week 4"));
            usage.put("solar", Arrays.asList(45.2, 52.8, 48.6, 51.3));
            usage.put("grid", Arrays.asList(38.5, 42.1, 39.8, 44.2));
        } else {
            // Weekly (default)
            usage.put("labels", Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
            usage.put("solar", Arrays.asList(12.5, 18.8, 21.2, 25.1, 23.8, 15.2, 10.1));
            usage.put("grid", Arrays.asList(15.2, 14.9, 12.5, 10.1, 11.3, 13.8, 16.5));
        }
        
        return ResponseEntity.ok(usage);
    }

    private Map<String, Object> createDayData(String day, double solar, double grid) {
        Map<String, Object> data = new HashMap<>();
        data.put("day", day);
        data.put("solar", solar);
        data.put("grid", grid);
        return data;
    }

    private Map<String, Object> createTip(String icon, String title, String description) {
        Map<String, Object> tip = new HashMap<>();
        tip.put("icon", icon);
        tip.put("title", title);
        tip.put("description", description);
        return tip;
    }

    private Map<String, Object> createQuickStat(String icon, String label, String value) {
        Map<String, Object> stat = new HashMap<>();
        stat.put("icon", icon);
        stat.put("label", label);
        stat.put("value", value);
        return stat;
    }
}
