import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { User } from '../_model/user';
import { HttpOptionsService } from './http-options.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly apiUrl = `${environment.apiUrl}`;
  jwtPayload: any;

  constructor(
    private http: HttpClient,
    private router: Router,
    private jwtHelperService: JwtHelperService,
    private httpOptionsService: HttpOptionsService
  ) {
    this.loadToken();
  }

  signIn(user: User): Promise<void> {

    const body = `username=${user.username}&password=${user.password}&grant_type=password`;

    return this.http.post(this.apiUrl + '/oauth/token', body, this.httpOptionsService.httpOptionsAuth)
      .toPromise()
      .then(response => {
        var token = this.formatterJson(response).access_token;
        this.storeToken(token);
        console.log(response);
      })
      .catch(response => {
        console.log(response);

        if (response.status == 400) {
          var responseJson = this.formatterJson(response);
          if (responseJson.error === 'invalid_grant') {
            return Promise.reject('Usuário ou senha inválida!');
          }
        }

        return Promise.reject(response);

      });
  }

  logout() {
    return this.http.delete(this.apiUrl + '/tokens/revoke', { withCredentials: true })
      .toPromise()
      .then(() => {
        this.cleanAccessToken();
      })
  }


  private loadToken() {
    const token = localStorage.getItem('token');
    if (token) {
      this.storeToken(token);
    }
  }

  private storeToken(token: string) {
    this.jwtPayload = this.jwtHelperService.decodeToken(token);
    localStorage.setItem('token', token);
  }

  private cleanAccessToken() {
    localStorage.removeItem('token');
    this.jwtPayload = null;
  }

  private formatterJson(data) {
    return JSON.parse(JSON.stringify(data));
  }

  getToken() {
    return this.formatterJson(localStorage.getItem('token'));
  }

}
