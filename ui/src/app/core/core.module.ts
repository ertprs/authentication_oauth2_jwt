import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AsideComponent } from './aside/aside.component';
import { HeaderComponent } from './header/header.component';
import { HeaderMobileComponent } from './header-mobile/header-mobile.component';
import { LanguageComponent } from './language/language.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { SubheaderComponent } from './subheader/subheader.component';
import { FooterComponent } from './footer/footer.component';



@NgModule({
  declarations: [
    AsideComponent, 
    HeaderComponent, 
    HeaderMobileComponent, 
    LanguageComponent, 
    UserProfileComponent,
    SubheaderComponent,
    FooterComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    AsideComponent,
    HeaderComponent,
    HeaderMobileComponent,
    LanguageComponent,
    UserProfileComponent,
    SubheaderComponent,
    FooterComponent
  ]
})
export class CoreModule { }
