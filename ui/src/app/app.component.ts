import { Component } from '@angular/core';
import { Router, NavigationEnd } from "@angular/router";

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

  constructor(private router: Router) {
    router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        let drawer: any = document.querySelector('paper-drawer-panel');
        drawer.closeDrawer();
      }
    });
  }
}
