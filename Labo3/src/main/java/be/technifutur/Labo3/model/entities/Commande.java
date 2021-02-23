package be.technifutur.Labo3.model.entities;

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

    @Column(nullable = false)
    LocalDateTime dateCreation;

    boolean estPaye;

    @ManyToMany
    List<Produit> produitsList;

    @ManyToOne
    Utilisateur utilisateur;
}
