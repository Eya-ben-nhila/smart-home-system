import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AlertsComponent } from './pages/alerts/alerts.component';
import { DeviceManagementComponent } from './pages/devices/devices.component';
import { EnergyComponent } from './pages/energy/energy.component';
import { SecurityComponent } from './pages/security/security.component';
import { AutomationsComponent } from './pages/automations/automations.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    AlertsComponent,
    DeviceManagementComponent,
    EnergyComponent,
    SecurityComponent,
    AutomationsComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
