# Smart Home Management System

A comprehensive smart home management system built with Angular (frontend) and Spring Boot (backend).

## 🏠 Project Overview

This project provides a complete smart home management solution with real-time device monitoring, energy analytics, security surveillance, and automated control systems.

## 🛠️ Technology Stack

### Frontend (Angular)
- **Framework**: Angular 17
- **Styling**: Tailwind CSS
- **Icons**: Material Symbols Outlined
- **Typography**: Space Grotesk
- **Build Tool**: Angular CLI
- **Package Manager**: npm

### Backend (Spring Boot)
- **Framework**: Spring Boot 3.2
- **Database**: H2 (In-memory)
- **ORM**: Spring Data JPA
- **Build Tool**: Maven
- **Security**: Spring Security
- **API**: RESTful endpoints

## 📁 Project Structure

```
pfe-stage/
├── smart-home-app/                 # Angular Frontend
│   ├── src/
│   │   ├── app/
│   │   │   ├── pages/            # Page Components
│   │   │   │   ├── dashboard/
│   │   │   │   ├── alerts/
│   │   │   │   ├── device-management/
│   │   │   │   ├── energy-analytics/
│   │   │   │   ├── security/
│   │   │   │   ├── automations/
│   │   │   │   └── user-profile/
│   │   ├── assets/                 # Static Assets
│   │   │   ├── images/
│   │   │   └── icons/
│   │   ├── environments/             # Environment Configurations
│   │   │   ├── environment.ts
│   │   │   └── environment.prod.ts
│   │   ├── styles/                 # Global Styles
│   │   │   ├── main.scss
│   │   │   └── tailwind.css
│   │   ├── package.json             # Dependencies
│   │   ├── angular.json             # Angular Configuration
│   │   ├── tsconfig.json             # TypeScript Configuration
│   │   └── tsconfig.app.json
│   └── index.html                # Main HTML Entry
├── smart-home-backend/                # Spring Boot Backend
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │           └── smarthome/
│   │               ├── controller/         # REST Controllers
│   │               ├── service/           # Business Logic
│   │               ├── model/             # Entity Classes
│   │               ├── repository/        # Data Access Layer
│   │               └── config/           # Configuration
│   └── pom.xml                    # Maven Configuration
├── stitch/                           # Design References
│   ├── smart_home_dashboard_1/
│   ├── smart_home_dashboard_2/
│   ├── alerts_and_notifications/
│   ├── device_settings_and_management_1/
│   ├── energy_consumption_analytics/
│   ├── security_and_live_surveillance_1/
│   └── user_profile/
└── README.md                          # Project Documentation
```

## 🚀 Quick Start

### Prerequisites
- Node.js 16+ or higher
- npm 8+ or higher
- Angular CLI 17+ or higher
- Java 17+ or higher
- Maven 3.6+ or higher

### Frontend Setup
```bash
# Clone and navigate to frontend
cd smart-home-app
npm install
ng serve
```

### Backend Setup
```bash
# Clone and navigate to backend
cd smart-home-backend
mvn spring-boot:run
```

### Access Points
- **Frontend**: http://localhost:4200
- **Backend**: http://localhost:8080
- **API Documentation**: Available at http://localhost:8080/swagger-ui.html

## 🎯 Features Implemented

### ✅ Frontend Features
- **Dashboard**: Real-time stats, device controls, smart scenes, security overview
- **Alerts**: Critical/warning/info filtering, alert management, dismiss functionality
- **Device Management**: Room-based organization, individual device controls, status monitoring
- **Energy Analytics**: Usage charts, cost tracking, solar monitoring
- **Security**: Live camera feeds, alarm controls, event timeline
- **Automations**: Scene management, automation rules, scheduling
- **User Profile**: Profile management, preferences, security settings

### ✅ Backend Features
- **Device Management**: CRUD operations for all smart home devices
- **Dashboard**: Statistics aggregation, device summaries
- **Alerts**: Alert persistence, filtering, and management
- **Energy**: Usage tracking and analytics
- **Security**: Security event logging and monitoring
- **Automations**: Scene and automation rule management
- **User Management**: Profile and preference storage
- **API**: RESTful endpoints for all frontend operations

## 🎨 Design Implementation

The application faithfully implements the designs from the `stitch/` folder, providing:
- **Modern UI**: Clean, responsive interface matching original designs
- **Consistent Styling**: Tailwind CSS classes and Material icons
- **Proper Architecture**: Component-based Angular structure
- **Real Functionality**: Working navigation, device controls, and data management

## 🔧 Development Ready

The project is fully set up for development and deployment. All components are functional and the application matches the original design specifications from your stitch folder.

## � Next Steps

1. **Run Locally**: Both frontend and backend can be run simultaneously
2. **Deploy**: Frontend can be built for production, backend for cloud deployment
3. **Extend**: Add more device types, automation rules, and analytics features
4. **Test**: Comprehensive testing suite included

## 🌟 Live Demo

**Current Status**: ✅ **Both frontend and backend are running locally**
- **Frontend URL**: http://localhost:4200
- **Backend URL**: http://localhost:8080

Your smart home management system is now complete and ready for use!

## 🔌 API Endpoints

### Devices
- `GET /api/devices` - Get all devices
- `GET /api/devices/{id}` - Get device by ID
- `GET /api/devices/room/{room}` - Get devices by room
- `POST /api/devices` - Create new device
- `PUT /api/devices/{id}` - Update device
- `PUT /api/devices/{id}/toggle` - Toggle device state
- `DELETE /api/devices/{id}` - Delete device

### Dashboard
- `GET /api/dashboard/stats` - Get dashboard statistics
- `GET /api/dashboard/devices` - Get dashboard devices
- `GET /api/dashboard/rooms` - Get room statistics

### Alerts
- `GET /api/alerts` - Get all alerts
- `GET /api/alerts/summary` - Get alert summary
- `POST /api/alerts/{id}/dismiss` - Dismiss alert

### Energy
- `GET /api/energy/stats` - Get energy statistics
- `GET /api/energy/usage` - Get usage data

### Security
- `GET /api/security/cameras` - Get camera feeds
- `GET /api/security/alerts` - Get security alerts
- `GET /api/security/clips` - Get event clips
- `GET /api/security/status` - Get security status
- `POST /api/security/alarm/{mode}` - Set alarm mode

### Automations
- `GET /api/automations/scenes` - Get scenes
- `GET /api/automations/automations` - Get automations
- `POST /api/automations/scenes/{id}/toggle` - Toggle scene
- `POST /api/automations/automations/{id}/toggle` - Toggle automation

### User
- `GET /api/user/profile` - Get user profile
- `GET /api/user/preferences` - Get user preferences
- `GET /api/user/security-settings` - Get security settings
- `PUT /api/user/profile` - Update profile
- `PUT /api/user/preferences` - Update preferences
- `PUT /api/user/security-settings` - Update security settings

## 🎨 Design System

The application uses a modern design system with:
- **Primary Color**: #197fe6 (Blue)
- **Success Color**: #0df259 (Green)
- **Warning Color**: #f59e0b (Amber)
- **Error Color**: #ef4444 (Red)
- **Typography**: Space Grotesk font family
- **Icons**: Material Symbols Outlined
- **Styling**: Tailwind CSS utility classes

## 🔧 Configuration

### Frontend
- Angular configuration in `angular.json`
- Tailwind configuration in `tailwind.config.js`
- TypeScript configuration in `tsconfig.json`

### Backend
- Spring Boot configuration in `application.properties`
- Database configuration for H2 (in-memory)
- CORS configuration for Angular frontend
- Security configuration for API endpoints

## 🧪 Testing

### Frontend Tests
```bash
cd smart-home-app
ng test
```

### Backend Tests
```bash
cd smart-home-backend
mvn test
```

## 📦 Building for Production

### Frontend
```bash
cd smart-home-app
ng build --configuration production
```

### Backend
```bash
cd smart-home-backend
mvn clean package
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 🙏 Acknowledgments

- Design inspiration from the stitch folder designs
- Material Design icons and components
- Tailwind CSS for styling
- Angular and Spring Boot frameworks
=======
# smart-home-system
Complete Smart Home Management System with Angular &amp; Spring Boot
>>>>>>> 75f76c969f9055711a2dba96f607510eb0e545b1
