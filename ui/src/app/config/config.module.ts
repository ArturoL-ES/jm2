import { NgModule } from "@angular/core";

import { i18nModule } from './i18n.module';
import { AppRouter } from './router.module';

@NgModule({
  exports: [
    AppRouter,
    i18nModule
  ]
})
export class ConfigModule { }