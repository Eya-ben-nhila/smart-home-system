import { Component } from '@angular/core';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.simple.html',
  styleUrls: ['./security.component.scss']
})
export class SecurityComponent {
  cameras = [
    { name: 'Front Door', status: 'LIVE', location: 'All clear' },
    { name: 'Backyard', status: 'LIVE', location: 'No motion' },
    { name: 'Garage', status: 'LIVE', location: 'Secured' },
    { name: 'Living Room', status: 'LIVE', location: 'Monitoring' }
  ];
}
