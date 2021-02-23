package com.openclassroom.Labo3.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FournisseurDTO {

    private int id;

    private String nom;

    private Enum status_social;

    private Enum secteur;

    private Timestamp date_insertion;

    private Timestamp date_update;
}
