package be.technifutur.Labo3.model.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Embeddable
public class Adresse{

    String rue;
    int numero;
    String codePostal;
    String ville;
    String pays;
}
