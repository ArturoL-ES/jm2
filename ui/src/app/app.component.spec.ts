import {TestBed, async, inject} from '@angular/core/testing';
import { APP_BASE_HREF } from '@angular/common';
import { HttpModule } from "@angular/http";
import { By } from "@angular/platform-browser";

import { AppComponent } from './app.component';
import { CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { AppRouter } from "./config/router.module";
import { i18nModule } from "./config/i18n.module";
import { HomeComponent } from "./home/home.component";
import { BuildsComponent } from "./builds/builds.component";
import {Router} from "@angular/router";


describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        HomeComponent,
        BuildsComponent
      ],
      imports: [
        HttpModule,
        AppRouter,
        i18nModule
      ],
      providers: [{provide: APP_BASE_HREF, useValue : '/' }], // FIXME: Esto deberia cogerlo del index.
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should contain the menu', async(() => {

  }));
});
