import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {ResourceModel} from '../../models/resource.model';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {map} from 'rxjs/operators';
import {ActivatedRoute} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class ResourceService {

  private resourcesUrl: string = '/api/resources/';
  private rentUrl: string = '/api/rent';
  private reserveUrl: string = '/api/reservation';
  constructor(private httpClient: HttpClient) {
  }

  public getResources(id: string): Observable<ResourceModel> {
    return this.httpClient
      .get(environment.serverPath + this.resourcesUrl + id )
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  public getScore(id: string): Observable<ResourceModel> {
    return this.httpClient
      .get(environment.serverPath + this.resourcesUrl + id )
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  public order(code: string): Observable<any> {
    let like =
      {
        "resourceCode": code,
        "userId": 1
      };
    return this.httpClient
      .post(environment.serverPath + this.rentUrl, like)
      .pipe(
        map((res: any) => {
          return res.product;
        })
      );
  }

  public reserve(code: string): Observable<any> {
    let like =
      {
        "userId": 1,
        "resourceCode": code
      };
    return this.httpClient
      .post(environment.serverPath + this.reserveUrl, like)
      .pipe(
        map((res: any) => {
          return res.product;
        })
      );
  }
}
