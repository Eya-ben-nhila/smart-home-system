import { Component } from '@angular/core';

@Component({
  selector: 'app-energy',
  templateUrl: './energy.component.html',
  styleUrls: ['./energy.component.scss']
})
export class EnergyComponent {
  currentUsage = 2.4;
  costSavings = 142.80;
  solarPercentage = 72;
}
