package be.technifutur.Labo3.model.dtos;

import be.technifutur.Labo3.model.entities.Produit;
import be.technifutur.Labo3.model.entities.enums.Secteur;
import be.technifutur.Labo3.model.entities.enums.StatutSocial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FournisseurDTO {


    int id;


    String entreprise;

    StatutSocial statutSocial;


    Secteur secteur;


    Instant dateInsertion;


    Instant dateUpdate;


    List<ProduitDTO> produits;
}
