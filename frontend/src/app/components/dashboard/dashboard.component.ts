import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {DashboardService} from './dashboard.service';
import {ResourceModel} from '../../models/resource.model';
import {Router} from '@angular/router';
import {ScannerComponent} from '../scanner/scanner.component';
import {MatDialog} from '@angular/material';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  filter = {value: ''};
    displayedColumns: string[] = ['name', 'code'];
    dataSource: MatTableDataSource<ResourceModel>;

    @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
    @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private service: DashboardService, private router: Router, public dialog: MatDialog) {
    }

  openDialog(): void {
    const dialogRef = this.dialog.open(ScannerComponent, {});

    dialogRef.afterClosed().subscribe(result => {
      this.filter.value = result;
      this.applyFilter(result);
      console.log('The dialog was closed');
    });
  }
    ngOnInit() {
        this.service.getResources().subscribe((res: ResourceModel[]) => {
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
        this.router.navigate(['/resource/' + row.code]);
    }
}
