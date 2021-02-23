package be.technifutur.Labo3.model.repositories;

import be.technifutur.Labo3.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
