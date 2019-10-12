import { Component, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  encapsulation: ViewEncapsulation.Emulated
})
export class AppComponent {
  title = 'frontend';

  constructor(private router: Router) {

  }

  public onClickLogo(): void {
    this.router.navigate(['./'])
  }
}
