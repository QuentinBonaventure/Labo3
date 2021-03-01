package be.technifutur.Labo3.model.entities;

import be.technifutur.Labo3.model.entities.enums.MoyenPayement;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    String reference;

    @Column(nullable = false)
    LocalDateTime dateCreation;

    @Column
    Boolean estPaye;

    @Column
    MoyenPayement moyenPayement;

    @ManyToMany
    List<Produit> produits;

    @ManyToOne
    Utilisateur utilisateur;


}
