package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.mapper.Mapper;
import be.technifutur.Labo3.model.dtos.CommandeDTO;
import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.repositories.CommandeRepository;
import be.technifutur.Labo3.model.repositories.ProduitRepository;
import be.technifutur.Labo3.model.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CommandeService  implements Crudable<Commande, CommandeDTO, Integer> {

    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final Mapper mapper;

    public CommandeService(CommandeRepository commandeRepository, ProduitRepository produitRepository, UtilisateurRepository utilisateurRepository, Mapper mapper) {
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CommandeDTO> getAll() {
        return this.commandeRepository.findAll().stream().map(c -> mapper.toCommandeDto(c)).collect(Collectors.toList());
    }

    @Override
    public CommandeDTO getById(Integer integer) {
        Commande commande = this.commandeRepository.findById(integer).orElseThrow(() -> new NoSuchElementException("Le fournisseur est mort"));
        commande.setProduits(this.produitRepository.findAllByCommandes(commande));
        commande.setUtilisateur(this.utilisateurRepository.findByCommandes(commande));
        return mapper.toCommandeDto(commande);
    }

    @Override
    public boolean insert(Commande commande) {
       Commande newCommande = this.commandeRepository.save(commande);
        return this.commandeRepository.findById(newCommande.getId()).isPresent();
    }

    @Override
    public boolean update(Commande commande, Integer integer) {
        Commande old = this.commandeRepository.getOne(integer);
        Commande toTest = new Commande(old.getId(), old.getReference(), old.getDateCreation(),old.getEstPaye(),old.getMoyenPayement(),old.getProduits(), old.getUtilisateur());
        commande.setId(integer);
        this.commandeRepository.save(commande);

        return !toTest.equals(this.commandeRepository.getOne(integer));
    }

    @Override
    public boolean delete(Integer integer) {
        this.commandeRepository.deleteById(integer);
        return this.commandeRepository.findById(integer).isEmpty();
    }
}
