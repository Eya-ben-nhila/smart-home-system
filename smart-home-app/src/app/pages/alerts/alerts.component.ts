import { Component } from '@angular/core';

@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: ['./alerts.component.scss']
})
export class AlertsComponent {
  criticalAlerts = [
    {
      id: 1,
      title: 'Motion Detected - Backyard',
      description: 'High-intensity motion detected by Rear Terrace Camera. Person identified near the perimeter.',
      time: '2 mins ago',
      icon: 'emergency_home',
      type: 'critical'
    },
    {
      id: 2,
      title: 'CO Detector Alert - Kitchen',
      description: 'Carbon Monoxide levels rising. Air purifier has been set to maximum.',
      time: '12 mins ago',
      icon: 'detector_smoke',
      actions: ['Emergency Protocol', 'Mute Alarm']
    }
  ];

  warningAlerts = [
    {
      id: 3,
      title: 'Low Battery - Front Door Lock',
      description: 'Battery level is at 8%. Please replace CR123A batteries soon to avoid lockout.',
      time: '1 hour ago',
      icon: 'battery_alert',
      actions: ['Order Batteries', 'Snooze']
    },
    {
      id: 4,
      title: 'Device Offline - Garage Thermostat',
      description: 'Connection lost. This may be due to a local Wi-Fi outage or device power failure.',
      time: '3 hours ago',
      icon: 'cloud_off',
      actions: ['Troubleshoot']
    }
  ];

  infoAlerts = [
    {
      id: 5,
      title: 'Vacuuming Completed',
      description: '"Dusty" has finished cleaning the First Floor and is returning to base. 120m² covered.',
      time: '5 hours ago',
      icon: 'cleaning_services',
      actions: ['View Report']
    },
    {
      id: 6,
      title: 'Smart Watering Active',
      description: 'Scheduled watering started for Zone 2 (Flower beds) based on local soil moisture.',
      time: '6 hours ago',
      icon: 'sprinkler',
      actions: []
    }
  ];

  alertSummary = {
    critical: 2,
    warnings: 4,
    info: 6
  };

  securityScore = 85;

  alerts = [
    { title: 'Motion Detected', type: 'critical', time: '2 mins ago' },
    { title: 'Door Unlocked', type: 'warning', time: '5 mins ago' },
    { title: 'System Update', type: 'info', time: '1 hour ago' }
  ];

  selectFilter(filter: string) {
    this.selectedFilter = filter;
  }
}
