package be.technifutur.Labo3.mapper;

import be.technifutur.Labo3.model.dtos.ProduitDTO;
import be.technifutur.Labo3.model.entities.Produit;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public ProduitDTO toProduitDto(Produit produit){
        return toProduitDto(produit);
    }

    public Produit toProduitEntity(ProduitDTO produit){
        return Produit.builder()
                .id(produit.getId())
                .nom(produit.getNom())
                .description(produit.getDescription())
                .categorie(produit.getCategorie())
                .dateEntree(produit.getDateEntree())
                .datePeremption(produit.getDatePeremption())
                .prixAchat(produit.getPrixAchat())
                .quantité(produit.getQuantité())
                .fournisseur(produit.getFournisseur())
                .imageProduit(produit.getImageProduit())
                .build();
    }
}
