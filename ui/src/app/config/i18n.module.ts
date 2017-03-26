import { NgModule } from "@angular/core";
import { Http } from '@angular/http';

import { TranslateModule, TranslateLoader, TranslateService } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

const defaultValues: any = {
  lang: 'es'
};

@NgModule({
  imports: [
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [Http]
      }
    })
  ],
  exports: [TranslateModule]
})
export class i18nModule {
  constructor(private translate: TranslateService) {
    translate.setDefaultLang(defaultValues.lang);
    translate.use(defaultValues.lang);
  }
}

function createTranslateLoader(http: Http) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}
