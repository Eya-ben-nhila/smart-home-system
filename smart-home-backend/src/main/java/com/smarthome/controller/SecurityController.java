package com.smarthome.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/security")
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {

    @GetMapping("/cameras")
    public ResponseEntity<List<Map<String, Object>>> getCameras() {
        List<Map<String, Object>> cameras = new ArrayList<>();
        
        cameras.add(createCamera(1L, "Front Door", "Live", 24, "1080P", true, 
            "https://lh3.googleusercontent.com/aida-public/AB6AXuBc7LSVaILskVKdt9XtmizdxnPeuk8pWsCDaQ0yvk7H179Sl-tAC9plZYzqtiM3PI6IQ4HzNf6UbqbxRbbydFXLgwA0jgHhHz_7NmubTI4lo93IKxPjHWf_XxgRaqiJUv_MUKZxTWNU-wDgxv3jL1I9w55PjpEhxCFS0XbNvkif5McoF3b4MNY2h4QB8jUiEdD0zwNNdtAf0GutUoJzf8AMD9PF4pMIkJ7ush9nqAezHRQ98B-vTtffMY9GFajb5ntcnIsy5LpN_ho"));
        
        cameras.add(createCamera(2L, "Backyard", "Live", 22, "1080P", false,
            "https://lh3.googleusercontent.com/aida-public/AB6AXuDSq9kUzZTBeazbNoI6XysQ0NSrnSDvhaNDm5gMFLs5tMGCRhUP0S9vsW6TPs0K-VvnhkvJTJp3qpad0A6BWzW_op8nciVP0Nzqb9EI8vQA1vSfjORZhKyzOEdxawjoMcV452_3kbIaNfcO1B2vF0n0qsvUSqQp5vRRzQi2q8EGiJvdv23Ia3kYQtomG06BxFkVbXWescaqDPV2XGd0RvUMgjzur64Px81IdtetCEQXHtZ4U60nPRUOtsM9bIxtuU7MwxGoC6ymk0k"));
        
        cameras.add(createCamera(3L, "Garage", "Live", 25, "1080P", false,
            "https://lh3.googleusercontent.com/aida-public/AB6AXuA47XR8tQdkLINVIOxatKliXmV61ZUZ4J47lBIAtJIkZ_SHUZem0w0tcBDSmjOE_x0WESl_elOe0TWJvg_-Kcmexl_sUJ1PzyXtaoO4uidTX5qzcO7PlglykMPm6kavOE4WV5M6CdmJg5K_AQ5Ntcln0dsAHZPPqfLomOZUWaaz330w9MUpGdo5ptneJVqpK3fz7qTPIhOVcDbYVXWyVxlF9tezpgIhV3Lr7f2ZJLihvvcGqiqMR7Zm_xdY0uQxkbF44uSuKzXFlms"));
        
        cameras.add(createCamera(4L, "Living Room", "Active Stream", 30, "1080P", true,
            "https://lh3.googleusercontent.com/aida-public/AB6AXuB8J6YiP-H0AsXXKr4ulj8O6OnSFaxKIzTtH9EbegSGG_8xUjvEii6OVqRKbJ1U7aCPLz0qbhFAu4gIc0PjzWoAudqmfrp5bALK1oEXxXgAwgw-kNO6E60cBYvtuWmm9-s4TaT58fgunkglLHYGwb1c5OqL4d721qWqz4G3NUMR1GWH9D0hrNUwD3Ac2EYuXxKJ0sOohAv23WTmDyNBHGRkq_i9C4DwepZdmXuncQ163ijsDXRt_6jfddxzyQVrNs2K-t6fkgEhTU0"));
        
        return ResponseEntity.ok(cameras);
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<Map<String, Object>>> getSecurityAlerts() {
        List<Map<String, Object>> alerts = new ArrayList<>();
        
        alerts.add(createSecurityAlert("person", "Person detected", "Front Door", "2m ago", "person_pin_circle", "orange-500"));
        alerts.add(createSecurityAlert("door", "Garage door opened", "Main Garage", "14m ago", "door_open", "primary"));
        alerts.add(createSecurityAlert("motion", "Unknown motion detected", "Backyard", "1h ago", "warning", "red-500"));
        alerts.add(createSecurityAlert("system", "System Disarmed", "By User: Felix", "2h ago", "power_settings_new", "emerald-500"));
        
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/clips")
    public ResponseEntity<List<Map<String, Object>>> getEventClips() {
        List<Map<String, Object>> clips = new ArrayList<>();
        
        clips.add(createEventClip("Package Delivered", "Front Door", "08:42 AM", "00:15",
            "https://lh3.googleusercontent.com/aida-public/AB6AXuBdMFHDVBHD5Ln62R4am_hygfTN1fgnGlB59jr2IQyDFOnrwzMvtweOQ-fVJMAZ3pSm07WpT4eNYzJUS4lCAAEy4vyurMVXiBe1VGzc6hQAa_6oe5erGaGzFq6VqOc-wmYoydCCP3InD7Yg3bmoz-JXXKa0RMeLKayWub08s1xg4dxsCqbiXc85WrxZV8zpAaIBkokcNUZmCXeiB-e5FdMtsFABEuzdp_McGZA3icwYUYGVrZfdlLVu9vOiuKXKKOyiFQbkYAkTQW8"));
        
        clips.add(createEventClip("Vehicle Arrival", "Main Garage", "07:15 AM", "00:42",
            "https://lh3.googleusercontent.com/aida-public/AB6AXuBBvIMRlhH2m_VRcREci-LwgDWNnWn_gXnUY4G3aeGg_gRZBj6mhSQP4RnVmMRBPz3MKmcxJrfRFOkCUiWIhhVBD43FCiAW9xwA7B4IgKMHnqNThUnmyWlXL1pNgDxQ2bQE28jQOx4n-2W4dzF9CCquBAApKtaU_yGitJ9JYg0v-Jt4CqsQO1_fzKsvMNY-f8eZ5AJz-b0YGls4oa7dPwoVEk7tYpbt-T1FRKTZMFtQDcDotEgWxyD91nl3GlmUv2_P2HlUFnjkdNk"));
        
        clips.add(createEventClip("Animal Detected", "Backyard", "04:30 AM", "01:05",
            "https://lh3.googleusercontent.com/aida-public/AB6AXuAOP1YzgLp4VEGRvKUIeVKWNNPcoM-GkQFQbNpe385pmfbaA3jlpPECoXn1KBAQWCzJF-5Y1wuAgmhE5en4jXz8oFQZLjdOVfFSagvmhuze9U2CAvqoKIDgaeDaXprvhpO0y5OsLcpPtBXK8Yz4qWrHu8uCzwZMRrsISlJg_hcwImY1U_OhD7E0cOfgkTLpvwApWB0H56nwnQIzKyOhMYkrBLjBWLr1uRmMIUHEOLCgihbVo2J6rdNPyyHXDp3W06YHuiBQuwi1EY"));
        
        return ResponseEntity.ok(clips);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getSecurityStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("alarmStatus", "Home (Armed)");
        status.put("selectedAlarmMode", "stay");
        status.put("systemStatus", "Secured");
        status.put("activeCameras", 4);
        status.put("recordingStatus", "On");
        status.put("diskUsage", 82);
        
        return ResponseEntity.ok(status);
    }

    @PostMapping("/alarm/{mode}")
    public ResponseEntity<Map<String, Object>> setAlarmMode(@PathVariable String mode) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("mode", mode);
        response.put("message", "Alarm mode set to " + mode);
        
        return ResponseEntity.ok(response);
    }

    private Map<String, Object> createCamera(Long id, String name, String status, int fps, String resolution, boolean isActive, String imageUrl) {
        Map<String, Object> camera = new HashMap<>();
        camera.put("id", id);
        camera.put("name", name);
        camera.put("status", status);
        camera.put("fps", fps);
        camera.put("resolution", resolution);
        camera.put("isActive", isActive);
        camera.put("imageUrl", imageUrl);
        return camera;
    }

    private Map<String, Object> createSecurityAlert(String type, String title, String location, String time, String icon, String color) {
        Map<String, Object> alert = new HashMap<>();
        alert.put("type", type);
        alert.put("title", title);
        alert.put("location", location);
        alert.put("time", time);
        alert.put("icon", icon);
        alert.put("color", color);
        return alert;
    }

    private Map<String, Object> createEventClip(String title, String location, String time, String duration, String thumbnail) {
        Map<String, Object> clip = new HashMap<>();
        clip.put("title", title);
        clip.put("location", location);
        clip.put("time", time);
        clip.put("duration", duration);
        clip.put("thumbnail", thumbnail);
        return clip;
    }
}
