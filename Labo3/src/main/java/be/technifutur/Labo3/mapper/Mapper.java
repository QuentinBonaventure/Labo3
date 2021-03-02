package be.technifutur.Labo3.mapper;

import be.technifutur.Labo3.model.dtos.CommandeDTO;
import be.technifutur.Labo3.model.dtos.FournisseurDTO;
import be.technifutur.Labo3.model.dtos.ProduitDTO;
import be.technifutur.Labo3.model.dtos.UtilisateurDTO;
import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.entities.Fournisseur;
import be.technifutur.Labo3.model.entities.Produit;
import be.technifutur.Labo3.model.entities.Utilisateur;
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
                .quantite(produit.getQuantite())
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
                .quantite(produitDTO.getQuantite())
                .imageProduit(produitDTO.getImageProduit())
                .fournisseur((produitDTO.getFournisseurDto() == null) ? null : toFournisseurEntity(produitDTO.getFournisseurDto()))
                .build();
    }

public FournisseurDTO toFournisseurDto(Fournisseur fournisseur){
            return toFournisseurDto(fournisseur, false);
}

    public FournisseurDTO toFournisseurDto(Fournisseur fournisseur , boolean withProduit){
        return FournisseurDTO.builder()
                .id(fournisseur.getId())
                .entreprise(fournisseur.getEntreprise())
                .statutSocial(fournisseur.getStatutSocial())
                .secteur(fournisseur.getSecteur())
                .dateInsertion(fournisseur.getDateInsertion())
                .dateUpdate(fournisseur.getDateUpdate())
                .produits(withProduit ? fournisseur.getProduits().stream().map(this::toProduitDto).collect(Collectors.toList()):null)
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

    public CommandeDTO toCommandeDto (Commande commande) {
        return toCommandeDto(commande, false);
    }

    public CommandeDTO toCommandeDto(Commande commande, boolean withUtilisateur){
            return CommandeDTO.builder()
                    .id(commande.getId())
                    .reference(commande.getReference())
                    .dateCreation(commande.getDateCreation())
                    .produitsDto(commande.getProduits()
                    .stream()
                    .map(this::toProduitDto)
                    .collect(Collectors.toList()))
                    .utilisateurDto(withUtilisateur ? toUtilisateurDTO(commande.getUtilisateur()) : null)
                    .estPaye(commande.getEstPaye())
                    .moyenPayement(commande.getMoyenPayement())
                    .build();
    }

        public Commande toCommandeEntity(CommandeDTO commandeDto){
            return Commande.builder()
                    .id(commandeDto.getId())
                    .reference(commandeDto.getReference())
                    .dateCreation(commandeDto.getDateCreation())
                    .produits(commandeDto.getProduitsDto()
                    .stream()
                    .map(this::toProduitEntity)
                    .collect(Collectors.toList()))
                    .utilisateur(toUtilisateurEntity(commandeDto.getUtilisateurDto()))
                    .estPaye(commandeDto.getEstPaye())
                    .moyenPayement(commandeDto.getMoyenPayement())
                    .build();
        }
        public UtilisateurDTO toUtilisateurDTO(Utilisateur utilisateur){
            return toUtilisateurDTO(utilisateur, false);
    }
        public UtilisateurDTO toUtilisateurDTO (Utilisateur utilisateur, boolean withCommande){
            return UtilisateurDTO.builder()
                    .id(utilisateur.getId())
                    .name(utilisateur.getName())
                    .firstName(utilisateur.getFirstName())
                    .droitAcces(utilisateur.getDroitAcces())
                    .pseudo(utilisateur.getPseudo())
                    .mdp(utilisateur.getMdp())
                    .adresse(utilisateur.getAdresse())
                    .commandes(withCommande ?utilisateur.getCommandes().stream().map(this::toCommandeDto).collect(Collectors.toList()) : null)
                    .build();
            }

    public Utilisateur toUtilisateurEntity (UtilisateurDTO utilisateur){
        return Utilisateur.builder()
                .id(utilisateur.getId())
                .name(utilisateur.getName())
                .firstName(utilisateur.getFirstName())
                .droitAcces(utilisateur.getDroitAcces())
                .pseudo(utilisateur.getPseudo())
                .mdp(utilisateur.getMdp())
                .adresse(utilisateur.getAdresse())
                .build();
    }
}
