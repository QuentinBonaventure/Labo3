import { Component, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/tables/Fournisseur';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Produit } from 'src/app/tables/Produit';
import { ApiServiceService } from 'src/app/services/api-service.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-fournisseurs',
  templateUrl: './fournisseurs.component.html',
  styleUrls: ['./fournisseurs.component.scss']
})
export class FournisseursComponent implements OnInit {

  listeProduits : Array<Produit> = [];
  listeFournisseurs : Array<Fournisseur> = [];
  listeSub : Subscription;
  detailsProduits : boolean = false;
  produitsFourn : Array<Produit>;
  fournisseur : String;
 

  constructor(private httpClient : HttpClient, private apiService : ApiServiceService) { }

  ngOnInit(): void {
    this.getAllFournisseurs();
    this.listeSub = this.apiService.fournisseurSubject.subscribe(
      (fournisseurs : any[]) => {
        this.listeFournisseurs = fournisseurs
      }
    )
    this.listeSub = this.apiService.produitSubject.subscribe(
      (produits : any[]) => {
        this.listeProduits = produits
      }
    )
    
  }


afficheProduits(objet : Produit[], fourn : String){
  this.detailsProduits = false;
  this.fournisseur ="";
  this.produitsFourn = [];
  this.produitsFourn = objet
  this.fournisseur =  fourn;
  this.detailsProduits = true;

 

 }


  getAllFournisseurs() {

    this.getAllProduits();
    this.apiService.getAll('http://localhost:8080/api/fournisseurs', 'fournisseurs');

    
  }

  getAllProduits() {
    
    this.apiService.getAll('http://localhost:8080/api/produits', 'produits');
  }


}
