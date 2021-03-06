import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AngularMaterialModule} from './modules/angular-material/angular-material.module';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {RoutingModule} from './modules/routing/routing.module';
import {LocationStrategy, PathLocationStrategy} from '@angular/common';
import {WishListComponent} from './components/wish-list/wish-list.component';
import {HttpClientModule} from '@angular/common/http';
import {FooterComponent} from './shared/footer/footer.component';
import {ResourceComponent} from './components/resource/resource.component';
import {HeadTitleComponent} from './shared/head-title/head-title.component';
import {ScannerComponent} from './components/scanner/scanner.component';
import {MAT_SNACK_BAR_DEFAULT_OPTIONS, MatDialogModule, MatDialogRef, MatSnackBarModule} from '@angular/material';
import {FormsModule} from "@angular/forms";
import { OwnedComponent } from './components/owned/owned.component';
import {SuccessfulComponent} from "./components/successful/successful.component";
import { AddWishComponent } from './components/add-wish/add-wish.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    WishListComponent,
    ResourceComponent,
    FooterComponent,
    HeadTitleComponent,
    ScannerComponent,
    OwnedComponent,
    SuccessfulComponent,
    AddWishComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    HttpClientModule,
    MatDialogModule,
    FormsModule,
    MatSnackBarModule
  ],
  providers: [Location, {provide: MatDialogRef, useValue: {}},
    {provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: {duration: 5000}}, {
    provide: LocationStrategy,
    useClass: PathLocationStrategy
  }],
  bootstrap: [AppComponent],
  entryComponents: [ScannerComponent, AddWishComponent, SuccessfulComponent]
})
export class AppModule { }
