import { Component, OnInit } from '@angular/core';
import { ScriptService } from 'src/app/_service/script.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor(
    private scriptService: ScriptService
  ) { }

  ngOnInit(): void {
    this.scriptService.loadExternalScript('./assets/js/footer.js').then(() => { }).catch(() => { });
  }

}
