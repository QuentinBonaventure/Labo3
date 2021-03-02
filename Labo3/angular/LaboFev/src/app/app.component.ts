import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ApiServiceService } from './services/api-service.service';
import { Utilisateur } from './tables/Utilisateur';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'LaboFev';

  produits : boolean = false;
  fournisseurs : boolean = false;
  signin : boolean = false;
  home : boolean = true;
  formLogin : FormGroup;
  pseudo : String ="";
  mdp : String ="";
  apiUtilisateurs : Array<Utilisateur> = [];
  utilSub : Subscription;
  isLogin : boolean;
  currentUser : Utilisateur;
  espaceperso : boolean = false;


constructor(private formBuilder : FormBuilder, private httpClient : HttpClient , private apiService : ApiServiceService){
  this.formLogin = this.formBuilder.group({
    pseudo : new FormControl("", [Validators.required]),
    mdp : new FormControl("", [Validators.required])
  })
}
ngOnInit(){
  this.formLogin = this.formBuilder.group({
    pseudo : new FormControl("", [Validators.required]),
    mdp : new FormControl("", [Validators.required])
  })
}
 
  
  getProduits(){
    this.produits = true;
    this.fournisseurs = false;
    this.signin = false;
    this.home = false;
  }

  getFournisseurs(){
    this.fournisseurs= true;
    this.produits = false;
    this.signin = false;
    this.home = false;
  }

  reload(){
    this.getHome()


  }
  signIn(){
  this.fournisseurs = false;
  this.produits = false;
  this.signin = true;
  this.home = false;
}

getHome() {
  this.home = true;
  this.fournisseurs= false;
  this.produits = false;
  this.signin = false;
}
onSubmit(){
this.pseudo = this.formLogin.get("pseudo").value;
this.mdp = this.formLogin.get("mdp").value;
this.apiService.getAll('http://localhost:8080/api/utilisateurs', 'utilisateurs');
this.utilSub = this.apiService.utilisateurSubject.subscribe(
  (utilisateurs : any[]) => {
    this.apiUtilisateurs = utilisateurs
    console.log(this.apiUtilisateurs);
    this.compare(this.apiUtilisateurs, this.pseudo, this.mdp);
  }
)

}
compare(utilisateurs : Array<Utilisateur>, pseudo : String ,mdp : String ){
  for(let utilisateur of utilisateurs){
    if(utilisateur.pseudo == pseudo && utilisateur.mdp == mdp){
      this.isLogin = true;
      this.currentUser = utilisateur;
      this.apiService.currentUser = utilisateur;
    }
    }
  

}
logOut(){
  this.isLogin = false;
  this.getHome();
}
espacePerso(){
this.espaceperso = true;
this.home = false;
this.fournisseurs= false;
this.produits = false;
this.signin = false;
}
}
