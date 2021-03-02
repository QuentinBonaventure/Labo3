import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from 'src/app/services/api-service.service';
import { Utilisateur } from 'src/app/tables/Utilisateur';

@Component({
  selector: 'app-espaceperso',
  templateUrl: './espaceperso.component.html',
  styleUrls: ['./espaceperso.component.scss']
})
export class EspacepersoComponent implements OnInit {
currentUser : Utilisateur;

donnees : boolean = false;
commandes : boolean = false;

  constructor(private apiService : ApiServiceService) { }

  ngOnInit(): void {
    this.currentUser = this.apiService.currentUser;
  }
afficheDonnees(){
  this.donnees = true;
}
cacheDonnees(){
  this.donnees = false;
}

afficheCommandes(){
  this.commandes = true;
}

cacheCommandes(){
  this.commandes = false;
}

}
