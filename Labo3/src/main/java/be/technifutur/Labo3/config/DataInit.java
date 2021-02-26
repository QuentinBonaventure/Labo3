package be.technifutur.Labo3.config;

import be.technifutur.Labo3.model.entities.Fournisseur;
import be.technifutur.Labo3.model.entities.Produit;
import be.technifutur.Labo3.model.entities.enums.Categorie;
import be.technifutur.Labo3.model.entities.enums.Secteur;
import be.technifutur.Labo3.model.entities.enums.StatutSocial;
import be.technifutur.Labo3.model.services.FournisseurService;
import be.technifutur.Labo3.model.services.ProduitService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataInit  implements InitializingBean {

    private final ProduitService produitService;
    private final FournisseurService fournisseurService;

    public DataInit(ProduitService produitService, FournisseurService fournisseurService) {
        this.produitService = produitService;
        this.fournisseurService = fournisseurService;
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
                    .quantité(8)
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
                    .quantité(25)
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
                    .quantité(19)
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
                    .quantité(24)
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
                    .quantité(30)
                    .fournisseur(fournisseurs.get(0))
                    .tva(6)
                    .build()
    );




    @Override
    public void afterPropertiesSet() throws Exception {
        this.fournisseurs.forEach(fournisseurService::insert);
        this.produits.forEach(produitService::insert);

    }
}
