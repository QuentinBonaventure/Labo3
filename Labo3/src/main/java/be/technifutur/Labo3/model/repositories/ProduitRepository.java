package be.technifutur.Labo3.model.repositories;

import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.entities.Fournisseur;
import be.technifutur.Labo3.model.entities.Produit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProduitRepository extends JpaRepository<Produit, Integer>  {
 List<Produit> findAllByFournisseur(Fournisseur fournisseur);

    List<Produit> findAllByCommandes(Commande commande);
}
