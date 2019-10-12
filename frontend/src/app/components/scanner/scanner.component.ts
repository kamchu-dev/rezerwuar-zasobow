import {Component, OnInit} from '@angular/core';
import quagga from 'quagga/dist/quagga';
import {MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-scanner',
  templateUrl: './scanner.component.html',
  styleUrls: ['./scanner.component.scss']
})
export class ScannerComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ScannerComponent>) {
  }

  ngOnInit() {
    const App = {
      _scanner: null, lastResult: undefined,

      activateScanner() {
        this.configureScanner();
      },
      configureScanner() {
        if (!this._scanner) {
          this._scanner = quagga.init({
              inputStream: {
                type: 'LiveStream',
                constraints: {
                  width: {min: 640}, height: {min: 480},
                  facingMode: 'environment', aspectRatio: {min: 1, max: 2}
                }
              },
              locator: {patchSize: 'medium', halfSample: true},
              numOfWorkers: 2, frequency: 10,
              decoder: {readers: [{format: 'ean_reader', config: {}}, {format: 'ean_reader', config: {}}]}, locate: true
            },
            // tslint:disable-next-line:only-arrow-functions
            function (err) {
              if (err) {
                console.log(err);
                return;
              }
              console.log('Initialization finished. Ready to start');
              quagga.start();
            });
        }
      }
    };
    quagga.onDetected(result => {
      const code = result.codeResult.code;
      if (App.lastResult === code) {
        console.log(code);
        quagga.stop();
        document.querySelector('#interactive').innerHTML = '';
        this.dialogRef.close(code);
      }
      App.lastResult = code;
    });
    App.activateScanner();
  }


}
