import {Component, OnInit} from '@angular/core';
import {ResourceModel} from '../../models/resource.model';
import {ResourceService} from './resource.service';
import {ActivatedRoute} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import {SuccessfulComponent} from '../successful/successful.component';

@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.scss']
})
export class ResourceComponent implements OnInit {

  id: string;
  dataSource: ResourceModel;

  constructor(private service: ResourceService, private snackBar: MatSnackBar, route: ActivatedRoute) {
    this.id = route.snapshot.params.id;
    this.snackBar = snackBar;
  }

  ngOnInit() {
    this.service.getResources(this.id).subscribe((res: ResourceModel) => {
      this.dataSource = res;
      console.log(this.dataSource);
    });
  }

  onClickOrder(code) {
    this.snackBar.openFromComponent(SuccessfulComponent, {
      duration: 5000,
      panelClass: ['successful-snackbar']
    });
    this.service.order(code).subscribe(() => {
    });
  }

  onClickReserve(code) {
    this.snackBar.openFromComponent(SuccessfulComponent, {
      duration: 5000,
      panelClass: ['successful-snackbar']
    });
    this.service.reserve(code).subscribe(() => {
    });
  }
}
