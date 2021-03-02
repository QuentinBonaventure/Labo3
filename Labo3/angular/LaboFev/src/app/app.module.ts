import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientJsonpModule, HttpClientModule, HttpParams } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FournisseursComponent } from './tablesComponents/fournisseurs/fournisseurs.component';
import { ProduitsComponent } from './tablesComponents/produits/produits.component';
import { ApiServiceService } from './services/api-service.service';
import { UtilisateursComponent } from './tablesComponents/utilisateurs/utilisateurs.component';
import { CommandesComponent } from './tablesComponents/commandes/commandes.component';
import { SignInComponent } from './tablesComponents/sign-in/sign-in.component';
import { HomeComponent } from './tablesComponents/home/home.component';
import { EspacepersoComponent } from './tablesComponents/espaceperso/espaceperso.component';

@NgModule({
  declarations: [
    AppComponent,
    FournisseursComponent,
    ProduitsComponent,
    UtilisateursComponent,
    CommandesComponent,
    SignInComponent,
    HomeComponent,
    EspacepersoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, HttpClientModule, HttpClientJsonpModule, ReactiveFormsModule
  ],
  providers: [ApiServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
