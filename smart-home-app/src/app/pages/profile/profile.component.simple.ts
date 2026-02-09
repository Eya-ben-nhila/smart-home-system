import { Component } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  userProfile = {
    name: 'Alex Johnson',
    email: 'alex.johnson@smarthome.com',
    plan: 'Premium Home',
    memberSince: 'January 2023'
  };

  preferences = {
    notifications: true,
    darkMode: true,
    autoAway: true,
    energySaving: false,
    voiceControl: true,
    locationSharing: false
  };

  securitySettings = {
    twoFactorAuth: true,
    biometricLogin: false,
    sessionTimeout: '30 minutes',
    trustedDevices: 3
  };

  updateProfile() {
    console.log('Profile updated');
  }

  updatePreferences() {
    console.log('Preferences updated');
  }

  updateSecuritySettings() {
    console.log('Security settings updated');
  }
}
