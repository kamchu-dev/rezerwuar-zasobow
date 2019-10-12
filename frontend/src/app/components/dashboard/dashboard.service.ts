import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResourceModel } from '../../models/resource.model';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class DashboardService {

    private resourcesUrl: string = '/resources';

    constructor(private httpClient: HttpClient) {

    }

    public getResources(): Observable<ResourceModel> {
        return this.httpClient
                   .get(environment.serverPath + this.resourcesUrl)
                   .pipe(
                       map((res: any) => {
                           return res.product;
                       })
                   );
    }
}
