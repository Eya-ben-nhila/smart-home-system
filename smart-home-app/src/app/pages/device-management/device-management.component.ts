import { Component } from '@angular/core';

@Component({
  selector: 'app-device-management',
  templateUrl: './device-management.component.html',
  styleUrls: ['./device-management.component.scss']
})
export class DeviceManagementComponent {
  selectedRoom = 'all';
  
  rooms = [
    { id: 'all', name: 'All Devices', icon: 'grid_view' },
    { id: 'living', name: 'Living Room', icon: 'chair' },
    { id: 'kitchen', name: 'Kitchen', icon: 'restaurant' },
    { id: 'bedroom', name: 'Bedroom', icon: 'bed' },
    { id: 'bathroom', name: 'Bathroom', icon: 'bathtub' }
  ];

  livingRoomDevices = [
    {
      name: 'Smart Eye Camera',
      type: 'camera',
      status: 'Online - Recording',
      battery: 92,
      isLive: true,
      resolution: '4K HDR',
      imageUrl: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBt8qz7oxQahrxwBRMqKAY3jheYdBTsHBIUa6ooViYFH2JVijkVg14iV1BiyU9AfvfBWdUAvvTXvzZw8Enw4cL1QzgW-yroNex4nc961Waxgvp5FR_OVEp4bfQsIRwZ3N91tg-JmssjdX1SZWuryPBA8Ws77WPS7eyB7A8GekDnVAuLu3pYIjFWwRJXE1cGZJHV_nz3oe1yCwrKU666adFp2gnflEmLw91E1U_suLzBykFykHf_jlU7kDuklVYXDmc7GD0z5LctOBQ'
    },
    {
      name: 'Main Chandelier',
      type: 'light',
      status: 'On',
      intensity: 75,
      isActive: true
    },
    {
      name: 'Living Room TV',
      type: 'tv',
      status: 'Currently Playing: Netflix',
      power: 'POWER ON',
      input: 'HDMI 1'
    },
    {
      name: 'Main AC Unit',
      type: 'thermostat',
      currentTemp: 22,
      targetTemp: 20,
      mode: 'Heating',
      icon: 'heat_pump',
      iconColor: 'text-orange-400'
    }
  ];

  kitchenDevices = [
    {
      name: 'Smart Fridge',
      type: 'fridge',
      fridgeTemp: 3,
      freezerTemp: -18
    },
    {
      name: 'Espresso Master',
      type: 'coffee',
      status: 'Ready to brew',
      canBrew: true
    },
    {
      name: 'Counter Lights',
      type: 'light',
      status: 'Off',
      isActive: false
    }
  ];

  thermostatData = {
    currentTemp: 22,
    targetTemp: 20.5,
    humidity: 45,
    fanSpeed: 'Auto',
    dailyUsage: [40, 55, 70, 90, 50, 30, 10]
  };

  selectRoom(roomId: string) {
    this.selectedRoom = roomId;
  }

  adjustTemp(delta: number) {
    this.thermostatData.targetTemp = Math.max(16, Math.min(30, this.thermostatData.targetTemp + delta));
  }

  setFanSpeed(speed: string) {
    this.thermostatData.fanSpeed = speed;
  }
}
