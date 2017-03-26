import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  private menu: Array<{name: string, path: string, icon: string}> = [
    {name: 'menu.home', path: 'home', icon: 'home'},
    {name: 'menu.builds', path: 'builds', icon: 'account-balance'}
  ];
  private menuSelected: {name: string, path: string, icon: string} = this.menu[0];

  constructor() { }

  public menuClick(item) {
    this.closeDrawer();
    this.menuSelected = item;
  }

  private closeDrawer() {
    let drawer: any = document.querySelector('paper-drawer-panel');
    drawer.closeDrawer();
  }
}
