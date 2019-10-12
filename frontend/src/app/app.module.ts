import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './modules/angular-material/angular-material.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RoutingModule } from './modules/routing/routing.module';
import { LocationStrategy, PathLocationStrategy } from '@angular/common';
import { ResourceComponent } from './components/resource/resource.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ResourceComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule
  ],
  providers: [Location, {provide: LocationStrategy, useClass: PathLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
