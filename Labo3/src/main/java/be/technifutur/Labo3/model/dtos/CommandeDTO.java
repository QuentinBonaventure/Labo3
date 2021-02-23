package be.technifutur.Labo3.model.dtos;

import be.technifutur.Labo3.model.entities.Produit;
import be.technifutur.Labo3.model.entities.Utilisateur;
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
    LocalDateTime dateCreation;
    boolean estPaye;
    List<Produit> produitsList;
    Utilisateur utilisateur;
}
