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
}
