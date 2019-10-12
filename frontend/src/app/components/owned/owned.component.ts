import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { DashboardService } from '../dashboard/dashboard.service';
import { Router } from '@angular/router';
import { AddWishComponent } from '../add-wish/add-wish.component';

@Component({
  selector: 'app-owned',
  templateUrl: './owned.component.html',
  styleUrls: ['./owned.component.scss']
})
export class OwnedComponent implements OnInit {

  filter = {value: ''};
  displayedColumns: string[] = ['name', 'rentDate', 'untilDate'];
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private service: DashboardService, private router: Router, public dialog: MatDialog) {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddWishComponent, {});


  }

  ngOnInit() {
    this.service.getMyResources().subscribe((res: any[]) => {
      this.dataSource = new MatTableDataSource(res);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  public onClickRow(row): void {
    this.router.navigate(['/resource/' + row.resourceCode]);
  }
}
