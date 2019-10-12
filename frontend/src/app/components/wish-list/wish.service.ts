import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {ResourceModel} from '../../models/resource.model';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WishService {

  private resourcesUrl: string = '/api/wish';
  private likesUrl: string = '/api/like';

  constructor(private httpClient: HttpClient) {

  }

  public getResources(): Observable<ResourceModel[]> {
    return this.httpClient
      .get(environment.serverPath + this.resourcesUrl)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  public addLike(row: any): Observable<any> {
    let like =
      {
        "userId": 1,
        "resourceCode": row.code
      };
    return this.httpClient
      .post(environment.serverPath + this.likesUrl, like)
      .pipe(

      );
  }
}
