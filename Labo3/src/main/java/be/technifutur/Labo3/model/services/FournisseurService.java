package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.mapper.Mapper;
import be.technifutur.Labo3.model.dtos.FournisseurDTO;
import be.technifutur.Labo3.model.entities.Fournisseur;
import be.technifutur.Labo3.model.repositories.FournisseurRepository;
import be.technifutur.Labo3.model.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FournisseurService implements Crudable<Fournisseur, FournisseurDTO,Integer> {

    private final ProduitRepository produitRepository;
    private final FournisseurRepository fournisseurRepository;
    private final Mapper mapper;

    public FournisseurService(ProduitRepository produitRepository, FournisseurRepository fournisseurRepository, Mapper mapper) {
        this.produitRepository = produitRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.mapper = mapper;
    }

    @Override
    public List<FournisseurDTO> getAll() {

        return this.fournisseurRepository.findAll()
                .stream()
                .map(f -> mapper.toFournisseurDto(f))
                .collect(Collectors.toList());
    }

    @Override
    public FournisseurDTO getById(Integer integer) {
        Fournisseur fournisseur = this.fournisseurRepository.findById(integer).orElseThrow(() -> new NoSuchElementException("Le fournisseur est mort"));
        fournisseur.setProduits(this.produitRepository.findAllByFournisseur(fournisseur));
        return mapper.toFournisseurDto(fournisseur);
    }

    @Override
    public boolean insert(Fournisseur fournisseur) {
        Fournisseur newFournisseur = this.fournisseurRepository.save(fournisseur);
        return this.fournisseurRepository.findById(newFournisseur.getId()).isPresent();
    }

    @Override
    public boolean update(Fournisseur fournisseur, Integer integer) {
        Fournisseur old = this.fournisseurRepository.getOne(integer);
        Fournisseur toTest = new Fournisseur(old.getId(), old.getEntreprise(), old.getStatutSocial(), old.getSecteur(), old.getDateInsertion(),
       old.getDateUpdate(), old.getProduits());
        fournisseur.setId(integer);
        this.fournisseurRepository.save(fournisseur);
        return !toTest.equals(this.fournisseurRepository.getOne(integer));
    }

    @Override
    public boolean delete(Integer integer) {

         this.fournisseurRepository.deleteById(integer);
         return this.fournisseurRepository.findById(integer).isEmpty();
    }
}
