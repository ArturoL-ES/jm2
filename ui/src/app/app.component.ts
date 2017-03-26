import { Component } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  menu: any[] = [
    {name: 'menu.home', path: 'home', icon: 'home'},
    {name: 'menu.builds', path: 'builds', icon: 'account-balance'}
  ];
}
