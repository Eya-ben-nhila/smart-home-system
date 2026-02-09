import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AlertsComponent } from './pages/alerts/alerts.component';
import { DeviceManagementComponent } from './pages/device-management/device-management.component';
import { EnergyAnalyticsComponent } from './pages/energy-analytics/energy-analytics.component';
import { SecurityComponent } from './pages/security/security.component';
import { AutomationsComponent } from './pages/automations/automations.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'alerts', component: AlertsComponent },
  { path: 'devices', component: DeviceManagementComponent },
  { path: 'energy', component: EnergyAnalyticsComponent },
  { path: 'security', component: SecurityComponent },
  { path: 'automations', component: AutomationsComponent },
  { path: 'profile', component: UserProfileComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
