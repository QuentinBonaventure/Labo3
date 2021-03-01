package be.technifutur.Labo3.model.repositories;

import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    List<Commande> findAllByUtilisateur(Utilisateur utilisateur);
}
