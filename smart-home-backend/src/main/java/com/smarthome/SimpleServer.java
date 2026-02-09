package com.smarthome;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // CORS headers handler
        server.createContext("/api/devices", new DevicesHandler());
        server.createContext("/api/dashboard/stats", new DashboardStatsHandler());
        server.createContext("/api/alerts", new AlertsHandler());
        server.createContext("/api/energy/stats", new EnergyStatsHandler());
        server.createContext("/api/security/cameras", new SecurityCamerasHandler());
        server.createContext("/api/automations/scenes", new AutomationsHandler());
        server.createContext("/api/user/profile", new UserProfileHandler());
        
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Smart Home Backend Server started on port 8080");
        System.out.println("API available at: http://localhost:8080/api");
    }
    
    static class DevicesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Add CORS headers
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Access-Control-Allow-Origin", "*");
            headers.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            headers.set("Access-Control-Allow-Headers", "*");
            
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "[{\"id\":1,\"name\":\"Living Room Lights\",\"type\":\"light\",\"room\":\"Living Room\",\"status\":\"On\",\"isActive\":true,\"intensity\":75}," +
                               "{\"id\":2,\"name\":\"Main AC Unit\",\"type\":\"thermostat\",\"room\":\"Living Room\",\"status\":\"On\",\"isActive\":true,\"currentTemp\":22.0,\"targetTemp\":20.5,\"mode\":\"Heating\"}," +
                               "{\"id\":3,\"name\":\"Smart Fridge\",\"type\":\"fridge\",\"room\":\"Kitchen\",\"status\":\"On\",\"isActive\":true,\"fridgeTemp\":3,\"freezerTemp\":-18}]";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
    
    static class DashboardStatsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Access-Control-Allow-Origin", "*");
            
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "{\"totalDevices\":6,\"activeDevices\":4,\"indoorTemp\":72,\"outdoorTemp\":65,\"humidity\":45}";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
    
    static class AlertsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Access-Control-Allow-Origin", "*");
            
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "[{\"id\":1,\"title\":\"Motion Detected - Backyard\",\"description\":\"High-intensity motion detected\",\"time\":\"2 mins ago\",\"icon\":\"emergency_home\",\"type\":\"critical\"}," +
                               "{\"id\":2,\"title\":\"Low Battery - Front Door Lock\",\"description\":\"Battery level is at 8%\",\"time\":\"1 hour ago\",\"icon\":\"battery_alert\",\"type\":\"warning\"}]";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
    
    static class EnergyStatsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Access-Control-Allow-Origin", "*");
            
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "{\"currentLoad\":2.41,\"voltage\":230.1,\"batteryLevel\":88.0,\"costSavings\":142.80,\"solarPercentage\":72,\"solarGeneration\":12.4,\"gridLoad\":4.8}";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
    
    static class SecurityCamerasHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Access-Control-Allow-Origin", "*");
            
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "[{\"id\":1,\"name\":\"Front Door\",\"status\":\"Live\",\"fps\":24,\"resolution\":\"1080P\",\"isActive\":true}," +
                               "{\"id\":2,\"name\":\"Backyard\",\"status\":\"Live\",\"fps\":22,\"resolution\":\"1080P\",\"isActive\":false}," +
                               "{\"id\":3,\"name\":\"Garage\",\"status\":\"Live\",\"fps\":25,\"resolution\":\"1080P\",\"isActive\":false}," +
                               "{\"id\":4,\"name\":\"Living Room\",\"status\":\"Active Stream\",\"fps\":30,\"resolution\":\"1080P\",\"isActive\":true}]";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
    
    static class AutomationsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Access-Control-Allow-Origin", "*");
            
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "[{\"id\":1,\"name\":\"Morning Routine\",\"description\":\"Gradually wake up with lights\",\"icon\":\"wb_twilight\",\"color\":\"orange\",\"active\":true,\"schedule\":\"6:30 AM\",\"devices\":5}," +
                               "{\"id\":2,\"name\":\"Good Night\",\"description\":\"Dim lights, lock doors\",\"icon\":\"bedtime\",\"color\":\"indigo\",\"active\":false,\"schedule\":\"10:30 PM\",\"devices\":8}]";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
    
    static class UserProfileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Access-Control-Allow-Origin", "*");
            
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "{\"name\":\"Alex Johnson\",\"email\":\"alex.johnson@smarthome.com\",\"plan\":\"Premium Home\",\"memberSince\":\"January 2023\"}";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
