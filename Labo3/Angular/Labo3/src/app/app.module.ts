import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FournisseursComponent } from '../components/fournisseurs/fournisseurs.component';
import {HttpClientModule, HttpClientJsonpModule, HttpClient} from  '@Angular/common/http';
import { ProduitsComponent } from '../components/produits/produits.component';
import { HomeComponent } from '../components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    FournisseursComponent,
    ProduitsComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpClientJsonpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
