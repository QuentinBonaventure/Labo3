package be.technifutur.Labo3.model.repositories;

import be.technifutur.Labo3.model.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
