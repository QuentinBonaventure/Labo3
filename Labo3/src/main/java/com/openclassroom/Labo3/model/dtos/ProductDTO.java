package com.openclassroom.Labo3.model.dtos;

import com.openclassroom.Labo3.model.entities.Category;
import com.openclassroom.Labo3.model.entities.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private int id;

    private String nom;

    private String description;

    private LocalDate dateEntree;

    private LocalDate dateUpdate;

    private LocalDate datePeremption;

    private Double prixAchat;

    private int quantité;

    private Category category;

    private Fournisseur fournisseur;

    private String imageProduit;

    private Double tva;

    //TODO liste des autres dtos
}
