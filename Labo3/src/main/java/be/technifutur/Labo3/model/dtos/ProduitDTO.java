package be.technifutur.Labo3.model.dtos;

import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.entities.Utilisateur;
import be.technifutur.Labo3.model.entities.enums.Categorie;
import be.technifutur.Labo3.model.entities.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {


    int id;



    String nom;


    String description;


    LocalDate dateInsertion;


    LocalDate dateUpdate;


    LocalDate datePeremption;


    Double prixAchat;

    int quantité;


    Categorie categorie;
    String imageProduit;

    int tva;


    FournisseurDTO fournisseurDto;


    List<CommandeDTO> commandesDto;






}
