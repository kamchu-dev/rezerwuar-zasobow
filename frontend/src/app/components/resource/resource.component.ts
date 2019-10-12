import { Component, OnInit } from '@angular/core';
import {ResourceModel} from "../../models/resource.model";
import {ResourceService} from "./resource.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from '@angular/common';
import {SuccessfulComponent} from '../successful/successful.component';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.scss']

})
export class ResourceComponent implements OnInit {

  id: string;
  dataSource: ResourceModel;
  showButtons: boolean;

  constructor(private service: ResourceService, route: ActivatedRoute, private snackBar: MatSnackBar, private location: Location) {
    this.id = route.snapshot.params.id;
    this.snackBar = snackBar;
    this.showButtons = true;
  }

  ngOnInit() {
    this.service.getResources(this.id).subscribe((res: ResourceModel) => {
      this.dataSource = res;
      console.log(this.dataSource);
    });
  }
onClickBack() {
    this.location.back();
}

    onClickOrder(code) {
        this.snackBar.openFromComponent(SuccessfulComponent, {
            duration: 5000,
            panelClass: ['successful-snackbar']
        });
        this.showButtons = false;
        this.service.order(code).subscribe(() => {
        });
    }

  onClickReserve(code) {
    this.snackBar.openFromComponent(SuccessfulComponent, {
      duration: 5000,
      panelClass: ['successful-snackbar']
    });
    this.showButtons = false;
    this.service.reserve(code).subscribe(() => {
    });
  }
}
