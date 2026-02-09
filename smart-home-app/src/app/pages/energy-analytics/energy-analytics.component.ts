import { Component } from '@angular/core';

@Component({
  selector: 'app-energy-analytics',
  templateUrl: './energy-analytics.component.html',
  styleUrls: ['./energy-analytics.component.scss']
})
export class EnergyAnalyticsComponent {
  selectedPeriod = 'weekly';
  
  currentLoad = 2.41;
  voltage = 230.1;
  batteryLevel = 88.0;
  
  costSavings = 142.80;
  solarPercentage = 72;
  solarGeneration = 12.4;
  gridLoad = 4.8;
  
  weeklyData = [
    { day: 'Mon', solar: 2.5, grid: 3.2 },
    { day: 'Tue', solar: 3.8, grid: 2.9 },
    { day: 'Wed', solar: 4.2, grid: 2.5 },
    { day: 'Thu', solar: 5.1, grid: 2.1 },
    { day: 'Fri', solar: 4.8, grid: 2.3 },
    { day: 'Sat', solar: 3.2, grid: 2.8 },
    { day: 'Sun', solar: 2.1, grid: 3.5 }
  ];

  efficiencyTips = [
    {
      icon: 'schedule',
      title: 'Shift Heavy Loads',
      description: 'Run dishwasher between 1 PM and 3 PM to utilize peak solar generation.'
    },
    {
      icon: 'thermostat',
      title: 'HVAC Optimization',
      description: 'Pre-cool home by 2°F while solar battery is full (80%+).'
    },
    {
      icon: 'power_settings_new',
      title: 'Vampire Loads',
      description: 'Entertainment center detected as active while not in use. Enable Eco-Sleep?'
    }
  ];

  quickStats = [
    { icon: 'eco', label: 'Carbon Offset', value: '124.5 kg' },
    { icon: 'battery_charging_full', label: 'Battery Health', value: '98.2%' },
    { icon: 'solar_power', label: 'Efficiency Score', value: '88/100' },
    { icon: 'energy_savings_leaf', label: 'Trees Equivalent', value: '6.2' }
  ];

  selectPeriod(period: string) {
    this.selectedPeriod = period;
  }
}
