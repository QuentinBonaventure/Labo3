package be.technifutur.Labo3.model.entities;

import be.technifutur.Labo3.model.entities.enums.Categorie;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

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
     LocalDate dateEntree;

    @Column
    LocalDate dateUpdate;

    @Column
     LocalDate datePeremption;

    @Column()
     Double prixAchat;
    @Column
     int quantité;

    @Column
    Categorie categorie;

    @OneToOne
    private Fournisseur fournisseur;

    @Column(columnDefinition = "varchar(255)")
     String imageProduit;

     Double tva;




}
