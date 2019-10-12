import { Component, OnInit } from '@angular/core';
import {ResourceModel} from "../../models/resource.model";
import {ResourceService} from "./resource.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.scss']
})
export class ResourceComponent implements OnInit {

  id: string;
  dataSource: ResourceModel;

  constructor(private service: ResourceService, route: ActivatedRoute) {
    this.id = route.snapshot.params.id;
  }

  ngOnInit() {
    this.service.getResources(this.id).subscribe((res: ResourceModel) => {
      this.dataSource = res;
      console.log(this.dataSource);
    });
  }
}
