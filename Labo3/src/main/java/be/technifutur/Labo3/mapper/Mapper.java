package be.technifutur.Labo3.mapper;

import be.technifutur.Labo3.model.dtos.FournisseurDTO;
import be.technifutur.Labo3.model.dtos.ProduitDTO;
import be.technifutur.Labo3.model.entities.Fournisseur;
import be.technifutur.Labo3.model.entities.Produit;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class Mapper {

//    public ProduitDTO toProduitDto(Produit produit){
//        return toProduitDto(produit, false);
//    }

        public ProduitDTO toProduitDto (Produit produit) {
            return toProduitDto(produit, false);
        }
    public ProduitDTO toProduitDto(Produit produit , boolean withFournisseur) {
        return ProduitDTO.builder()
                .id(produit.getId())
                .nom(produit.getNom())
                .description(produit.getDescription())
                .categorie(produit.getCategorie())
                .dateInsertion(produit.getDateInsertion())
                .dateUpdate(produit.getDateUpdate())
                .datePeremption(produit.getDatePeremption())
                .prixAchat(produit.getPrixAchat())
                .quantité(produit.getQuantité())
                .imageProduit(produit.getImageProduit())
                .fournisseurDto(withFournisseur ? toFournisseurDto(produit.getFournisseur()) : null)
                .build();
    }




    public Produit toProduitEntity(ProduitDTO produitDTO){
        return Produit.builder()
                .id(produitDTO.getId())
                .nom(produitDTO.getNom())
                .description(produitDTO.getDescription())
                .categorie(produitDTO.getCategorie())
                .dateInsertion(produitDTO.getDateInsertion())
                .dateUpdate(produitDTO.getDateUpdate())
                .datePeremption(produitDTO.getDatePeremption())
                .prixAchat(produitDTO.getPrixAchat())
                .quantité(produitDTO.getQuantité())
                .imageProduit(produitDTO.getImageProduit())
                .fournisseur(toFournisseurEntity(produitDTO.getFournisseurDto()))
                .build();
    }



    public FournisseurDTO toFournisseurDto(Fournisseur fournisseur ){
        return FournisseurDTO.builder()
                .id(fournisseur.getId())
                .entreprise(fournisseur.getEntreprise())
                .statutSocial(fournisseur.getStatutSocial())
                .secteur(fournisseur.getSecteur())
                .dateInsertion(fournisseur.getDateInsertion())
                .dateUpdate(fournisseur.getDateUpdate())
                .produits( fournisseur.getProduits().stream().map(this::toProduitDto).collect(Collectors.toList()))
                .build();

    }

    public Fournisseur toFournisseurEntity(FournisseurDTO fournisseurDTO){
        return Fournisseur.builder()
                .id(fournisseurDTO.getId())
                .entreprise(fournisseurDTO.getEntreprise())
                .statutSocial(fournisseurDTO.getStatutSocial())
                .secteur(fournisseurDTO.getSecteur())
                .dateInsertion(fournisseurDTO.getDateInsertion())
                .dateUpdate(fournisseurDTO.getDateUpdate())

                .build();
    }


}
