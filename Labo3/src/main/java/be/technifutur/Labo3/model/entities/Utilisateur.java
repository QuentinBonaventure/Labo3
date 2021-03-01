package be.technifutur.Labo3.model.entities;


import be.technifutur.Labo3.model.entities.enums.Droits;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
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
    String name;

    @Column(nullable = false,length = 50)
    String firstName;

    @Column(nullable = false)
    Droits droitAcces;



    @Column(length = 50, nullable = false)
    String pseudo;

    @Column(length = 50,nullable = false)
    String mdp;

    @Embedded
    Adresse adresse;

    @OneToMany(mappedBy = "utilisateur")
    List<Commande> commandes = new ArrayList<>();




}
