import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './_service/auth.service';
import { MessageService } from './_service/message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  loggedUser = false;

  constructor(
    private messageService: MessageService,
    private router: Router,
    private authService: AuthService
  ) {
    this.checkLoggedUser()
  }


  private checkLoggedUser() {
    const currentUser = this.authService.getToken();
    if (!currentUser) {
      this.loggedUser = false;
      this.router.navigate(['/']);
    } else {
      this.loggedUser = true;
      this.router.navigate(['/dashboard']);
      this.messageService.sendMessage('success', "Você já está logado");
    }

    console.log("loggedUser: " + this.loggedUser)
  }



}
