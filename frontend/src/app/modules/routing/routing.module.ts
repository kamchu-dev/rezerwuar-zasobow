import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from '../../components/dashboard/dashboard.component';
import { WishListComponent } from '../../components/wish-list/wish-list.component';
import {ResourceComponent} from "../../components/resource/resource.component";
import { OwnedComponent } from '../../components/owned/owned.component';

const routes: Routes = [
  { path: 'wish-list', component: WishListComponent },
  { path: 'rent', component: DashboardComponent },
  { path: 'resource/:id', component: ResourceComponent },
  { path: 'owned', component: OwnedComponent },
  { path: '', component: DashboardComponent },
  { path: '**', component: DashboardComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(
        routes,
        { enableTracing: true } // <-- debugging purposes only
    )
  ],
  exports: [
      RouterModule
  ]
})
export class RoutingModule { }
