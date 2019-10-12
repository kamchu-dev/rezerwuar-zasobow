import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './modules/angular-material/angular-material.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RoutingModule } from './modules/routing/routing.module';
import { LocationStrategy, PathLocationStrategy } from '@angular/common';
import { WishListComponent } from './components/wish-list/wish-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './shared/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    WishListComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    HttpClientModule
  ],
  providers: [Location, {provide: LocationStrategy, useClass: PathLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
