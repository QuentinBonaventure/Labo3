package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.mapper.Mapper;
import be.technifutur.Labo3.model.dtos.ProduitDTO;
import be.technifutur.Labo3.model.entities.Produit;

import be.technifutur.Labo3.model.repositories.FournisseurRepository;
import be.technifutur.Labo3.model.repositories.ProduitRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProduitService implements Crudable<Produit, ProduitDTO, Integer>{

    private final ProduitRepository produitRepository;
    private final FournisseurRepository fournisseurRepository;

    private final Mapper mapper;



    public ProduitService(ProduitRepository produitRepository, FournisseurRepository fournisseurRepository, Mapper mapper) {
        this.produitRepository = produitRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ProduitDTO> getAll() {
        return this.produitRepository.findAll()
                .stream()
                .map(p -> mapper.toProduitDto(p, true))
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDTO getById(Integer integer) {

        Produit produit = this.produitRepository.findById(integer).orElseThrow(() -> new NoSuchElementException("Le produit n'existe pas"));
       produit.setFournisseur(this.fournisseurRepository.findByProduits(produit));

        return mapper.toProduitDto(produit, true);

    }

    @Override
    public boolean insert(Produit produit) {
        Produit newProduit = this.produitRepository.save(produit);
        return this.produitRepository.findById(newProduit.getId()).isPresent();
    }

    @Override
    public boolean update(Produit produit, Integer integer) {
        Produit old = this.produitRepository.getOne(integer);
        Produit toTest = new Produit(old.getId(), old.getNom(),old.getDescription(),old.getDateInsertion(),
                old.getDateUpdate(),old.getDatePeremption(), old.getPrixAchat(),old.getQuantité(),old.getImageProduit()
                ,old.getTva(),old.getCategorie(),old.getFournisseur(),old.getCommandes(), old.getUtilisateurs());
        produit.setId(integer);
        this.produitRepository.save(produit);

        return !toTest.equals(this.produitRepository.getOne(integer));
    }

    @Override
    public boolean delete(Integer integer) {
        this.produitRepository.deleteById(integer);
        return this.produitRepository.findById(integer).isEmpty();
    }

    public boolean partialUpdate(Map<String, Object> updates, Integer integer) throws IllegalAccessException {
        Produit produitToUpdate = this.mapper.toProduitEntity(getById(integer));
        Class<?> clazz = Produit.class;

        Field[] fields = clazz.getDeclaredFields();

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            Field field = Arrays.stream(fields)
                    .filter(f -> f.getName().equals(entry.getKey()))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("La propriété de la classe n'a pas été trouvé"));
            field.setAccessible(true);
            field.set(produitToUpdate, entry.getValue());
        }

        this.produitRepository.save(produitToUpdate);

        return true;
    }
}
