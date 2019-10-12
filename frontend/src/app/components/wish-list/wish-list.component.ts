import {Component, OnInit, ViewChild} from '@angular/core';
import {ResourceModel} from '../../models/resource.model';
import {MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from '@angular/material';
import {WishService} from './wish.service';
import {SuccessfulComponent} from '../successful/successful.component';

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

  constructor(private service: WishService, private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.service.getResources().subscribe((res: ResourceModel[]) => {
      this.dataSource = new MatTableDataSource(res);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  onClickLike(row){
    if (!row.canLike){
      return;
    }
    this.snackBar.openFromComponent(SuccessfulComponent, {
      duration: 5000,
      panelClass: ['successful-snackbar']
    });
    this.service.addLike(row).subscribe(() => {
        const newObj: ResourceModel = {
          name: row.name,
          likes: row.likes + 1,
          url: row.url,
          price: row.price,
          canLike: row.canLike
        };
      this.dataSource.data.map((obj) => {
        if(obj.code == row.code){
          obj.likes++;
          obj.canLike = !obj.canLike;
        }
      });
      console.dir(this.dataSource);
    });
  }

}
