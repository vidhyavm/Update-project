import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtClientService } from './jwt-client.service';

@Injectable({providedIn: 'root'})
export class AdminAuthGuard implements CanActivate
{

  constructor(private jwtService: JwtClientService, private router:Router){}
  
  
  canActivate(
     route: ActivatedRouteSnapshot,
     state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree
     {

     if(this.jwtService.isAdminLoggedIn() )
     {
      return true;
     }
     this.router.navigate(['login']);
     return false;
    }

}
