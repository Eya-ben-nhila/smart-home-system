import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.simple.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {
  indoorTemp = 72;
  outdoorTemp = 65;
  humidity = 45;
  
  devices = [
    { name: 'Living Room', status: 'On', intensity: 80, active: true, icon: 'lightbulb' },
    { name: 'Kitchen AC', status: 'Standby', intensity: 0, active: false, icon: 'air' }
  ];
  
  activeDevices = [
    { name: 'Living Room Lights', status: '75% brightness', active: true, icon: 'light' },
    { name: 'Main AC', status: 'Set to 72°', active: true, icon: 'ac_unit' }
  ];
  
  scenes = [
    { name: 'Morning', icon: 'wb_twilight', schedule: '6:30 AM' },
    { name: 'Good Night', icon: 'bedtime', schedule: '10:30 PM' },
    { name: 'Movie', icon: 'movie', schedule: 'Manual' },
    { name: 'Away', icon: 'directions_walk', schedule: 'Geofence' }
  ];
  
  cameras = [
    { name: 'Front Door', location: 'All clear', status: 'LIVE', image: 'https://picsum.photos/400/300?random=1' },
    { name: 'Backyard', location: 'No motion', status: 'LIVE', image: 'https://picsum.photos/400/300?random=2' },
    { name: 'Garage', location: 'Secured', status: 'LIVE', image: 'https://picsum.photos/400/300?random=3' },
    { name: 'Living Room', location: 'Monitoring', status: 'LIVE', image: 'https://picsum.photos/400/300?random=4' }
  ];
}
