package be.technifutur.Labo3.model.dtos;

import be.technifutur.Labo3.model.entities.enums.Categorie;
import be.technifutur.Labo3.model.entities.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {

    private int id;

    private String nom;

    private String description;

    private LocalDate dateEntree;

    private LocalDate dateUpdate;

    private LocalDate datePeremption;

    private Double prixAchat;

    private int quantité;

    private Categorie categorie;

    private Fournisseur fournisseur;

    private String imageProduit;

    private Double tva;

    //TODO liste des autres dtos
}
