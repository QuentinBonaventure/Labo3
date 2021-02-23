package be.technifutur.Labo3.model.dtos;

import be.technifutur.Labo3.model.entities.Adresse;
import be.technifutur.Labo3.model.entities.Commande;
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
    String nom;
    String prenom;
    Enum DroitAcces;
    String avatar;
    String pseudo;
    String mdp;
    Adresse adresse;
    List<Commande> commandes;

}
