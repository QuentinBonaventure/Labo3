import { Adresse } from "./Adresse";
import { Commande } from "./Commande";
import { Produit } from "./Produit";


export interface Utilisateur {

    id : number,
    name : String,
    firstName : String,
    droitAcces : String,
    pseudo : String,
    mdp : String,
    adresse : Adresse,
    commandes : Array<Commande>,
    
}