package be.technifutur.Labo3.model.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false,length = 50)
    String nom;

    @Column(nullable = false,length = 50)
    String prenom;
    @Column(nullable = false)
    Enum DroitAcces;

    @Column
    String avatar;

    @Column(length = 50, nullable = false)
    String pseudo;

    @Column(length = 50,nullable = false)
    String mdp;

    @Embedded
    Adresse adresse;

    @OneToMany
    List<Commande> commandes;


}
