package com.smarthome.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getUserProfile() {
        Map<String, Object> profile = new HashMap<>();
        
        profile.put("name", "Alex Johnson");
        profile.put("email", "alex.johnson@smarthome.com");
        profile.put("plan", "Premium Home");
        profile.put("memberSince", "January 2023");
        profile.put("avatar", "https://lh3.googleusercontent.com/aida-public/AB6AXuBJxi8uzmPiWMwd_M5ZMlNHbd6f4AkdcBXV1PZhu9eetimfy2E9AxHLhOHduqBBozpIGSitAdkw_YEMUOyFQMuIOIZB87LgOt6CGFm-Bm3ggTwW1oP0NFHpPkFDmQWPOqaLR7ULtBqLyA9o8Z_7ZP9QLJX-y1ZLOTkNJwmmxLjbRR__Rn99ww2gFao1RLBU5jE388GJhf299Qskfc8itc1mDrc6URicSE45iCwePIyMAgXHNI1BWjceifHNWSZYuA2DFmjyb8XEj54");
        
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/preferences")
    public ResponseEntity<Map<String, Object>> getUserPreferences() {
        Map<String, Object> preferences = new HashMap<>();
        
        preferences.put("notifications", true);
        preferences.put("darkMode", true);
        preferences.put("autoAway", true);
        preferences.put("energySaving", false);
        preferences.put("voiceControl", true);
        preferences.put("locationSharing", false);
        
        return ResponseEntity.ok(preferences);
    }

    @GetMapping("/security-settings")
    public ResponseEntity<Map<String, Object>> getSecuritySettings() {
        Map<String, Object> security = new HashMap<>();
        
        security.put("twoFactorAuth", true);
        security.put("biometricLogin", false);
        security.put("sessionTimeout", "30 minutes");
        security.put("trustedDevices", 3);
        
        return ResponseEntity.ok(security);
    }

    @PutMapping("/profile")
    public ResponseEntity<Map<String, Object>> updateProfile(@RequestBody Map<String, Object> profileData) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Profile updated successfully");
        
        return ResponseEntity.ok(response);
    }

    @PutMapping("/preferences")
    public ResponseEntity<Map<String, Object>> updatePreferences(@RequestBody Map<String, Object> preferencesData) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Preferences updated successfully");
        
        return ResponseEntity.ok(response);
    }

    @PutMapping("/security-settings")
    public ResponseEntity<Map<String, Object>> updateSecuritySettings(@RequestBody Map<String, Object> securityData) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Security settings updated successfully");
        
        return ResponseEntity.ok(response);
    }
}
