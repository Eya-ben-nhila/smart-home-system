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

  recentAlerts = [
    {
      type: 'person',
      title: 'Person detected',
      location: 'Front Door',
      time: '2m ago',
      icon: 'person_pin_circle',
      color: 'orange-500'
    },
    {
      type: 'door',
      title: 'Garage door opened',
      location: 'Main Garage',
      time: '14m ago',
      icon: 'door_open',
      color: 'primary'
    },
    {
      type: 'motion',
      title: 'Unknown motion detected',
      location: 'Backyard',
      time: '1h ago',
      icon: 'warning',
      color: 'red-500'
    },
    {
      type: 'system',
      title: 'System Disarmed',
      location: 'By User: Felix',
      time: '2h ago',
      icon: 'power_settings_new',
      color: 'emerald-500'
    }
  ];

  eventClips = [
    {
      title: 'Package Delivered',
      location: 'Front Door',
      time: '08:42 AM',
      duration: '00:15',
      thumbnail: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBdMFHDVBHD5Ln62R4am_hygfTN1fgnGlB59jr2IQyDFOnrwzMvtweOQ-fVJMAZ3pSm07WpT4eNYzJUS4lCAAEy4vyurMVXiBe1VGzc6hQAa_6oe5erGaGzFq6VqOc-wmYoydCCP3InD7Yg3bmoz-JXXKa0RMeLKayWub08s1xg4dxsCqbiXc85WrxZV8zpAaIBkokcNUZmCXeiB-e5FdMtsFABEuzdp_McGZA3icwYUYGVrZfdlLVu9vOiuKXKKOyiFQbkYAkTQW8'
    },
    {
      title: 'Vehicle Arrival',
      location: 'Main Garage',
      time: '07:15 AM',
      duration: '00:42',
      thumbnail: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBBvIMRlhH2m_VRcREci-LwgDWNnWn_gXnUY4G3aeGg_gRZBj6mhSQP4RnVmMRBPz3MKmcxJrfRFOkCUiWIhhVBD43FCiAW9xwA7B4IgKMHnqNThUnmyWlXL1pNgDxQ2bQE28jQOx4n-2W4dzF9CCquBAApKtaU_yGitJ9JYg0v-Jt4CqsQO1_fzKsvMNY-f8eZ5AJz-b0YGls4oa7dPwoVEk7tYpbt-T1FRKTZMFtQDcDotEgWxyD91nl3GlmUv2_P2HlUFnjkdNk'
    },
    {
      title: 'Animal Detected',
      location: 'Backyard',
      time: '04:30 AM',
      duration: '01:05',
      thumbnail: 'https://lh3.googleusercontent.com/aida-public/AB6AXuAOP1YzgLp4VEGRvKUIeVKWNNPcoM-GkQFQbNpe385pmfbaA3jlpPECoXn1KBAQWCzJF-5Y1wuAgmhE5en4jXz8oFQZLjdOVfFSagvmhuze9U2CAvqoKIDgaeDaXprvhpO0y5OsLcpPtBXK8Yz4qWrHu5uCzwZMRrsISlJg_hcwImY1U_OhD7E0cOfgkTLpvwApWB0H56nwnQIzKyOhMYkrBLjBWLr1uRmMIUHEOLCgihbVo2J6rdNPyyHXDp3W06YHuiBQuwi1EY'
    }
  ];

  alarmStatus = 'Home (Armed)';
  selectedAlarmMode = 'stay';
}
