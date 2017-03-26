import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  appTitle = 'JM2';
  menu: any[] = [
    {name: 'home', path: 'home', icon: 'home'},
    {name: 'builds', path: 'builds', icon: 'account-balance'}
  ];
}
