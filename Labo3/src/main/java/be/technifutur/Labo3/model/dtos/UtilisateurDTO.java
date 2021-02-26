package be.technifutur.Labo3.model.dtos;

import be.technifutur.Labo3.model.entities.Adresse;
import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.entities.Produit;
import be.technifutur.Labo3.model.entities.enums.Droits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurDTO {


    int id;

    String name;


    String firstName;


    Droits DroitAcces;


    String avatar;


    String pseudo;


    String mdp;


    Adresse adresse;


    List<Commande> commandes;


    List<Produit> produitsList;

}
