package be.technifutur.Labo3.model.repositories;

import be.technifutur.Labo3.model.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
