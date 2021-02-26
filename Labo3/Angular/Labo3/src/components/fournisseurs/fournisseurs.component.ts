
import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Fournisseur } from '../../app/tables/Fournisseur';
import { Produit } from 'src/app/tables/Produit';
@Component({
  selector: 'app-fournisseurs',
  templateUrl: './fournisseurs.component.html',
  styleUrls: ['./fournisseurs.component.scss']
})
export class FournisseursComponent implements OnInit {

  listeFournisseurs : Array<Fournisseur> = [];
  listeProduits : Array<Produit> = [];
  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
  }

  getAllFournisseurs() {

this.getAllProduits();
    this.httpClient.get<Fournisseur[]>('http://localhost:8080/api/fournisseurs')
    .subscribe(
      (response) => {
        this.listeFournisseurs = response;
        console.log("Ca passe au moins...")
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error)
      }
    
    )
    console.log(this.listeFournisseurs );
    console.log( this.listeProduits);
  }

  getAllProduits() {

    this.httpClient.get<Produit[]>('http://localhost:8080/api/produits')
    .subscribe(
      (response) => {
        this.listeProduits = response;
        console.log("Ca passe au moins...")
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error)
      }
    )
  }

}
