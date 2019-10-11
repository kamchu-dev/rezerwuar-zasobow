import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from '../../components/dashboard/dashboard.component';

const routes: Routes = [
  { path: './', component: DashboardComponent },
  { path: '', component: DashboardComponent },
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
