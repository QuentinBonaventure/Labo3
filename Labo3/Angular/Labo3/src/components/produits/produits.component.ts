import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/tables/Produit';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.scss']
})
export class ProduitsComponent implements OnInit {

  listeProduits : Array<Produit> = [];
  

  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
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
