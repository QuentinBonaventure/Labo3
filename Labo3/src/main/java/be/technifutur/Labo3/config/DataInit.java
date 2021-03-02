package be.technifutur.Labo3.config;

import be.technifutur.Labo3.model.entities.*;
import be.technifutur.Labo3.model.entities.enums.*;
import be.technifutur.Labo3.model.services.CommandeService;
import be.technifutur.Labo3.model.services.FournisseurService;
import be.technifutur.Labo3.model.services.ProduitService;
import be.technifutur.Labo3.model.services.UtilisateurService;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Data
public class DataInit  implements InitializingBean {

    private final ProduitService produitService;
    private final FournisseurService fournisseurService;
    private final UtilisateurService utilisateurService;
    private final CommandeService commandeService;

    public DataInit(ProduitService produitService, FournisseurService fournisseurService, UtilisateurService utilisateurService, CommandeService commandeService) {
        this.produitService = produitService;
        this.fournisseurService = fournisseurService;
        this.utilisateurService = utilisateurService;
        this.commandeService = commandeService;
    }

    private List<Fournisseur> fournisseurs = Arrays.asList(
            Fournisseur.builder()
            .entreprise("Micha")
            .statutSocial(StatutSocial.SPRL)
            .secteur(Secteur.Alimentaire)
            .dateInsertion(Instant.now())
            .dateUpdate(Instant.now())

            .build(),

            Fournisseur.builder()
                    .entreprise("Curnel")
                    .statutSocial(StatutSocial.SPRL)
                    .secteur(Secteur.Alimentaire)
                    .dateInsertion(Instant.now())
                    .dateUpdate(Instant.now())
                    .build(),
            Fournisseur.builder()
                    .entreprise("Boushaba")
                    .statutSocial(StatutSocial.SPRL)
                    .secteur(Secteur.Alimentaire)
                    .dateInsertion(Instant.now())
                    .dateUpdate(Instant.now())
                    .build(),

            Fournisseur.builder()
                    .entreprise("Renmans")
                    .statutSocial(StatutSocial.SA)
                    .secteur(Secteur.Alimentaire)
                    .dateInsertion(Instant.now())
                    .dateUpdate(Instant.now())
                    .build()

    );

    private List<Produit> produits = Arrays.asList(
            Produit.builder()
                    .nom("Limousine")
                    .description("Viande tendre du Limousin")
                    .categorie(Categorie.Entrecote)
                    .dateInsertion(LocalDate.now())
                    .dateUpdate(LocalDate.now())
                    .datePeremption(LocalDate.now().plusDays(15))
                    .prixAchat(26.6)
                    .quantite(8)
                    .fournisseur(fournisseurs.get(1))
                    .tva(6)
                    .build(),
            Produit.builder()
                    .nom("Merguez")
                    .description("Saucisse d'agneau épicée")
                    .categorie(Categorie.Saucisse)
                    .dateInsertion(LocalDate.now())
                    .dateUpdate(LocalDate.now())
                    .datePeremption(LocalDate.now().plusDays(15))
                    .prixAchat(12.7)
                    .quantite(25)
                    .fournisseur(fournisseurs.get(2))
                    .tva(6)
                    .build(),
            Produit.builder()
                    .nom("Ribs d'agneau")
                    .description("Delicieux cote sautée d'agneau")
                    .categorie(Categorie.Poitrine)
                    .dateInsertion(LocalDate.now())
                    .dateUpdate(LocalDate.now())
                    .datePeremption(LocalDate.now().plusDays(15))
                    .prixAchat(26.2)
                    .quantite(19)
                    .fournisseur(fournisseurs.get(2))
                    .tva(6)
                    .build(),
            Produit.builder()
                    .nom("Chipolata")
                    .description("Saucisse porc nature")
                    .categorie(Categorie.Saucisse)
                    .dateInsertion(LocalDate.now())
                    .dateUpdate(LocalDate.now())
                    .datePeremption(LocalDate.now().plusDays(15))
                    .prixAchat(11.0)
                    .quantite(24)
                    .fournisseur(fournisseurs.get(3))
                    .tva(6)
                    .build(),
            Produit.builder()
                    .nom("Pure boeuf")
                    .description("Hachis pure boeuf idéal pour les burgers")
                    .categorie(Categorie.Entrecote)
                    .dateInsertion(LocalDate.now())
                    .dateUpdate(LocalDate.now())
                    .datePeremption(LocalDate.now().plusDays(15))
                    .prixAchat(16.3)
                    .quantite(30)
                    .fournisseur(fournisseurs.get(0))
                    .tva(6)
                    .build()
    );
    private List<Utilisateur> utilisateurs = Arrays.asList(
            Utilisateur.builder()
                    .name("Pothen")
                    .firstName("Julien")
                    .droitAcces(Droits.Administrateur)
                    .pseudo("Julburn")
                    .mdp("4960")
                    .adresse(new Adresse("Chemin bidule", 6 ,"4960", "Malmedy", "Belgique"))
                    .build(),
            Utilisateur.builder()
                    .name("Bonaventure")
                    .firstName("Quentin")
                    .droitAcces(Droits.Administrateur)
                    .pseudo("Qbona")
                    .mdp("4970")
                    .adresse(new Adresse("rue du rondeau", 6 ,"4970", "Stavelot", "Belgique"))
                    .build(),
            Utilisateur.builder()
                    .name("Alorchi")
                    .firstName("Medhi")
                    .droitAcces(Droits.Employe)
                    .pseudo("Medar")
                    .mdp("4920")
                    .adresse(new Adresse("chemin du congelateur", 4 ,"4960", "Malmedy", "Belgique"))
                    .build(),

            Utilisateur.builder()
                    .name("Jordan")
                    .firstName("Michael")
                    .droitAcces(Droits.Administrateur)
                    .pseudo("His Airness")
                    .mdp("4970")
                    .adresse(new Adresse("Rue all offame", 23 ,"2015", "Washington", "Usa"))
                    .build()

    );

    private List<Commande> commandes = Arrays.asList(
         Commande.builder()
                 .reference("QJ00001")
                 .dateCreation(LocalDateTime.of(2021,02,28,17,06))
                 .estPaye(true)
                 .moyenPayement(MoyenPayement.Cash)
                 .produits(Arrays.asList( produits.get(1), produits.get(4)))
                 .utilisateur(utilisateurs.get(0))
                 .build(),

            Commande.builder()
                    .reference("QJ00002")
                    .dateCreation(LocalDateTime.of(2021,02,28,18,06))
                    .estPaye(true)
                    .moyenPayement(MoyenPayement.Mastercard)
                    .produits(Arrays.asList( produits.get(2), produits.get(3)))
                    .utilisateur(utilisateurs.get(1))
                    .build(),
            Commande.builder()
                    .reference("QJ00003")
                    .dateCreation(LocalDateTime.of(2021,02,27,14,06))
                    .estPaye(true)
                    .moyenPayement(MoyenPayement.Mastercard)
                    .produits(Arrays.asList( produits.get(1), produits.get(3)))
                    .utilisateur(utilisateurs.get(2))
                    .build(),
            Commande.builder()
                    .reference("QJ00004")
                    .dateCreation(LocalDateTime.of(2021,03,01,10,06))
                    .estPaye(true)
                    .moyenPayement(MoyenPayement.Mastercard)
                    .produits(Arrays.asList( produits.get(2), produits.get(4),produits.get(1)))
                    .utilisateur(utilisateurs.get(3))
                    .build()



    );




    @Override
    public void afterPropertiesSet() throws Exception {
        this.fournisseurs.forEach(fournisseurService::insert);
        this.produits.forEach(produitService::insert);
        this.utilisateurs.forEach(utilisateurService::insert);
        this.commandes.forEach(commandeService::insert);

    }
}
