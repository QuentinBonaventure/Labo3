import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Adresse } from 'src/app/tables/Adresse';
import { Utilisateur } from 'src/app/tables/Utilisateur';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {
  formSignIn : FormGroup;
  newAdresse : Adresse ;
  newUser : Utilisateur;

  constructor(private formBuilder : FormBuilder, private httpClient : HttpClient) {
 
   }

  ngOnInit(): void {
    this.formSignIn = this.formBuilder.group({
      name : new FormControl("",[Validators.required]),
      firstName : new FormControl("", [Validators.required]),
      pseudo : new FormControl("", [Validators.required]),
      mdp : new FormControl("", [Validators.required]),
      rue : new FormControl("", [Validators.required]),
      numero : new FormControl("", [Validators.required]),
      codePostal : new FormControl("", [Validators.required]),
      ville : new FormControl("", [Validators.required]),
      pays : new FormControl("", [Validators.required]),
      
    })
  
  }

  onSubmit(){
    if(this.formSignIn.invalid){
      alert("Formulaire invalide");
    }else {
      let adress : Adresse ={ rue : '' , numero : null , codePostal : '' , ville : '', pays : ''};
      adress.rue = this.formSignIn.get("rue").value
      adress.numero = this.formSignIn.get("numero").value
      adress.codePostal = this.formSignIn.get("codePostal").value
      adress.ville = this.formSignIn.get("ville").value
      adress.pays = this.formSignIn.get("pays").value
      this.newAdresse = adress;
      
      let user : Utilisateur = { id : null, name : '', firstName : '', droitAcces : '', pseudo :'', mdp : '', adresse : null, commandes : null}
      user.name = this.formSignIn.get("name").value
      user.firstName = this.formSignIn.get("firstName").value
      user.droitAcces = "Utilisateur"
      user.pseudo = this.formSignIn.get("pseudo").value
      user.mdp = this.formSignIn.get("mdp").value
      user.adresse = this.newAdresse
      user.commandes = null
      this.newUser = user
      console.log(this.newUser)

      this.httpClient.post('http://localhost:8080/api/utilisateurs', this.newUser)
      .subscribe( () => {
        console.log("Utilisateur rajouté à la DB")
      }, (error) => console.log("l'ajout a merdé, voici l'erreure" + error))
    }
    location.reload()
  }
 
}
