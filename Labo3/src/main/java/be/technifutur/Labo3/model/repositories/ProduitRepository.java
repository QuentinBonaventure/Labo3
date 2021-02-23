package be.technifutur.Labo3.model.repositories;

import be.technifutur.Labo3.model.entities.Produit;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Integer>  {

}
