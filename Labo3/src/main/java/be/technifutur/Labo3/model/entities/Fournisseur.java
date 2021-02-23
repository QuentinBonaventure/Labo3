package be.technifutur.Labo3.model.entities;

import be.technifutur.Labo3.model.entities.enums.Secteur;
import be.technifutur.Labo3.model.entities.enums.StatutSocial;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column( nullable = false,columnDefinition = "varchar(100)")
    String nom;
    @Column
    StatutSocial status_social;

    @Column
    Secteur secteur;

    @Column(nullable = false)
    Timestamp date_insertion;

    @Column(nullable = false)
    Timestamp date_update;



}
