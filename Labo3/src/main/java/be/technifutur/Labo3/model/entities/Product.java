package be.technifutur.Labo3.model.entities;

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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column
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
     Category category;


    //private Fournisseur fournisseur;

    @Column
     String imageProduit;

     Double tva;




}
