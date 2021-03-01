import { Produit } from "./Produit";
import { Utilisateur } from "./Utilisateur";

export interface Commande {
    id : number,
    reference : string,
    
    dateCreation : Date,
    estPaye : boolean,
    produits : Array<Produit>,
    utilisateur : Utilisateur;
}