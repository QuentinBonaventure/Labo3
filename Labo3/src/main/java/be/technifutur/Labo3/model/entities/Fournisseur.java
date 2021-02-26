package be.technifutur.Labo3.model.entities;

import be.technifutur.Labo3.model.entities.enums.Secteur;
import be.technifutur.Labo3.model.entities.enums.StatutSocial;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
    String entreprise;

    @Column
    StatutSocial statutSocial;

    @Column
    Secteur secteur;

    @NotNull
    @CreationTimestamp
    Instant dateInsertion;


    @UpdateTimestamp
    Instant dateUpdate;

    @OneToMany(mappedBy = "fournisseur")
    List<Produit> produits = new ArrayList<>();



}
