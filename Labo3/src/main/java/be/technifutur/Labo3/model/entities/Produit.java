package be.technifutur.Labo3.model.entities;

import be.technifutur.Labo3.model.entities.enums.Categorie;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column( nullable = false,columnDefinition = "varchar(255)")

    String nom;

    @Column
     String description;

    @Column
     LocalDate dateInsertion;

    @Column
    LocalDate dateUpdate;

    @Column
     LocalDate datePeremption;

    @Column()
     Double prixAchat;
    @Column
     int quantité;

    @Column(columnDefinition = "varchar(255)")
    String imageProduit;

    @Column(nullable = false)
    int tva;

    @Column
    Categorie categorie;

    @ManyToOne
   Fournisseur fournisseur;


    @ManyToMany(mappedBy = "produits")
    List<Commande> commandes;

    @ManyToMany(mappedBy = "produitsList")
    List<Utilisateur> utilisateurs;



}
