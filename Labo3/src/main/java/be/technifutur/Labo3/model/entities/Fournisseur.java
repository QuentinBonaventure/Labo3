package be.technifutur.Labo3.model.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;
    @Column
    private Enum status_social;

    @Column
    private Enum secteur;

    @Column

    private Timestamp date_insertion;


    @Column
    private Timestamp date_update;



}
