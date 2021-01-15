import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/_model/user';
import { AuthService } from 'src/app/_service/auth.service';
import { MessageService } from 'src/app/_service/message.service';
import { ScriptService } from 'src/app/_service/script.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;

  constructor(
    private scriptService: ScriptService,
    private authSrvice: AuthService,
    private user: User,
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    //this.scriptService.loadExternalScript('./assets/js/login.js').then(() => { }).catch(() => { });
  }

  login(form: NgForm) {
    console.log(form.value.username);
    console.log(form.value.password);
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
