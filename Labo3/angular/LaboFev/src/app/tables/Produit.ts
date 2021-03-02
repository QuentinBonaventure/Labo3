import { Fournisseur } from "./Fournisseur";

export interface Produit {

    id : number,
    nom : String,
    description : String,
    categorie : String,
    dateInsertion : Date,
    dateUpdate : Date,
    datePeremption : Date,
    prixAchat : number,
    quantite : number,
    imageProduit : String,
    tva : number,
    fournisseurDto : Fournisseur
}