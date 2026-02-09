import { Component } from '@angular/core';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.scss']
})
export class DevicesComponent {
  devices = [
    { name: 'Living Room Lights', type: 'light', room: 'Living Room', status: 'On' },
    { name: 'Kitchen AC', type: 'thermostat', room: 'Kitchen', status: 'Off' },
    { name: 'Smart TV', type: 'entertainment', room: 'Living Room', status: 'On' }
  ];
}
