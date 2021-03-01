package be.technifutur.Labo3.model.dtos;

import be.technifutur.Labo3.model.entities.Produit;
import be.technifutur.Labo3.model.entities.Utilisateur;
import be.technifutur.Labo3.model.entities.enums.MoyenPayement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeDTO {


    int id;
    String reference;

    LocalDateTime dateCreation;


    Boolean estPaye;

    MoyenPayement moyenPayement;

    List<ProduitDTO> produitsDto;


    UtilisateurDTO utilisateurDto;
}
