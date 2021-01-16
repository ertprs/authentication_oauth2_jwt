import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ngxLoadingAnimationTypes, NgxLoadingModule } from 'ngx-loading';
import { LoaderComponent } from './loader/loader.component';



@NgModule({
  declarations: [LoaderComponent],
  imports: [
    CommonModule,
    NgxLoadingModule.forRoot({
      fullScreenBackdrop: true,
      animationType: ngxLoadingAnimationTypes.threeBounce,
      backdropBackgroundColour: 'rgba(0,0,0,0.5)',
      backdropBorderRadius: '4px',
      primaryColour: '#3699FF',
      secondaryColour: '#7DB8F4',
      tertiaryColour: '#C4DFFB'
    })
  ],
  exports: [
    LoaderComponent
  ]
})
export class LoaderModule { }
