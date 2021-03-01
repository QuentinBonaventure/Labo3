import { Adresse } from "./Adresse";
import { Commande } from "./Commande";
import { Produit } from "./Produit";

export interface Utilisateur {
    id: number,
    name: String,
    firstname: String,
    droitsAcces : String,
    avatar : String,
    pseudo : String,
    adresse : Adresse,
    commandes : Array<Commande>,
    produits :Array<Produit>;
    
}