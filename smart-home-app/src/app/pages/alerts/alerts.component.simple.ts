import { Component } from '@angular/core';

@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.simple.html',
  styleUrls: ['./alerts.component.scss']
})
export class AlertsComponent {
  alerts = [
    { title: 'Motion Detected', type: 'critical', time: '2 mins ago' },
    { title: 'Door Unlocked', type: 'warning', time: '5 mins ago' },
    { title: 'System Update', type: 'info', time: '1 hour ago' }
  ];
}
