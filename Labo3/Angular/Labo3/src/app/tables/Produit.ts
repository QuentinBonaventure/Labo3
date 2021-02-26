import { Fournisseur } from "./Fournisseur";

export interface Produit {

    id : number,
    nom : String,
    description : String,
    categorie : String,
    date_insertion : Date,
    date_update : Date,
    date_peremption : Date,
    prix_achat : number,
    quantite : number,
    image_Produit : String,
    tva : number,
    fournisseursDto : Fournisseur
}