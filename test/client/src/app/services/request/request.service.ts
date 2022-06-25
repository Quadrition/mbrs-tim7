import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../model/User';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class RequestService {
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(
        private http: HttpClient
    ) { }

    post_method(request: any, body: any): Observable<any>{
        return this.http.post(request, body, {headers: this.headers, responseType: 'json'});
    }

    get_method(request: any, ): Observable<any>{
        return this.http.get(request, {headers: this.headers, responseType: 'json'}).pipe(map(res => res));
    }

    put_method(request: any, body: any): Observable<any>{
        return this.http.put(request, body, {headers: this.headers, responseType: 'json'});
    }
    
    delete_method(request: any): Observable<any>{
        return this.http.delete(request, {headers: this.headers, responseType: 'json'});
    }

}
