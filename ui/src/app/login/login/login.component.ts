import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/_model/user';
import { AuthService } from 'src/app/_service/auth.service';
import { MessageService } from 'src/app/_service/message.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;


  constructor(
    private authSrvice: AuthService,
    private user: User,
    private messageService: MessageService,
    private router: Router,

  ) {

  }

  ngOnInit(): void {
  }

  login(form: NgForm) {
    this.user.username = form.value.username;
    this.user.password = form.value.password;
    this.authSrvice.signIn(this.user)
      .then((response) => {
        //this.router.navigate(['/dashboard']);
        window.location.href = '/dashboard';
        this.messageService.sendMessage('success', 'Login realizado com sucesso!');
      })
      .catch(error => {
        this.messageService.sendMessage('error', 'Usuário ou senha incorreta.');
      });
  }

}
