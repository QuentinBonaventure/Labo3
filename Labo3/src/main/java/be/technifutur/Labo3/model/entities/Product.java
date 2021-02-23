package com.openclassroom.Labo3.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    @Column
    private String description;

    @Column
    private LocalDate dateEntree;

    @Column
    private LocalDate dateUpdate;

    @Column
    private LocalDate datePeremption;

    @Column()
    private Double prixAchat;
    @Column
    private int quantité;


    //private Category category;


    //private Fournisseur fournisseur;

    @Column
    private String imageProduit;

    private Double tva;




}
