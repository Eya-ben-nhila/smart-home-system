import { Component } from '@angular/core';

@Component({
  selector: 'app-automations',
  templateUrl: './automations.component.html',
  styleUrls: ['./automations.component.scss']
})
export class AutomationsComponent {
  selectedTab = 'scenes';
  
  scenes = [
    {
      name: 'Morning Routine',
      description: 'Gradually wake up with lights, open blinds, start coffee maker',
      icon: 'wb_twilight',
      color: 'orange',
      active: true,
      schedule: '6:30 AM',
      devices: 5
    },
    {
      name: 'Good Night',
      description: 'Dim lights, lock doors, arm security system',
      icon: 'bedtime',
      color: 'indigo',
  ];

  automations = [
    { name: 'Motion-Activated Lights', trigger: 'Motion detected', action: 'Turn on lights', active: true },
    { name: 'Temperature Control', trigger: 'Temperature > 75°F', action: 'Turn on AC', active: false },
    { name: 'Door Lock Alert', trigger: 'Front door unlocked', action: 'Send notification', active: false }
  ];

  selectedTab = 'scenes';

  selectTab(tab: string) {
    this.selectedTab = tab;
  }

  toggleScene(sceneId: number) {
    const scene = this.scenes.find(s => s.name === sceneId);
    if (scene) {
      scene.active = !scene.active;
    }
  }

  toggleAutomation(automationId: number) {
    const automation = this.automations.find(a => a.name === automationId);
    if (automation) {
      automation.active = !automation.active;
    }
  }
}
