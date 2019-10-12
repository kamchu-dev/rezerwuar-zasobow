import {Component, OnInit, ViewChild} from '@angular/core';
import {ResourceModel} from "../../models/resource.model";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {WishService} from "./wish.service";
import { WishListModel } from '../../models/wish-list.model';

@Component({
  selector: 'app-wish-list',
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.scss']
})
export class WishListComponent implements OnInit {

  displayedColumns: string[] = ['name', 'url', 'price', 'likes'];
  dataSource: MatTableDataSource<ResourceModel>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private service: WishService) { }

  ngOnInit() {
    this.service.getResources().subscribe((res: ResourceModel[]) => {
      this.dataSource = new MatTableDataSource(res);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  onClickLike(row){
    this.service.addLike(row).subscribe(() => {
        const newObj: WishListModel = {
          name: row.name,
          likes: row.likes + 1,
          url: row.url,
          price: row.price
        };
        console.log('update');
    });
  }
}
