package be.technifutur.Labo3.model.entities;

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

    @Column
    String nom;
    @Column
    Enum status_social;

    @Column
    Enum secteur;

    @Column

     Timestamp date_insertion;


    @Column
    private Timestamp date_update;



}
