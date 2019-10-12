import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-add-wish',
  templateUrl: './add-wish.component.html',
  styleUrls: ['./add-wish.component.scss']
})
export class AddWishComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AddWishComponent>) {
  }

  ngOnInit() {
  }

}
