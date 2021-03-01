package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.mapper.Mapper;
import be.technifutur.Labo3.model.dtos.UtilisateurDTO;
import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.entities.Utilisateur;
import be.technifutur.Labo3.model.repositories.CommandeRepository;
import be.technifutur.Labo3.model.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements Crudable<Utilisateur, UtilisateurDTO, Integer>{

    private final UtilisateurRepository utilisateurRepository;
    private final CommandeRepository commandeRepository;
    private final Mapper mapper;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, CommandeRepository commandeRepository, Mapper mapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.commandeRepository = commandeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UtilisateurDTO> getAll() {
        return this.utilisateurRepository.findAll().stream()
                .map(u -> mapper.toUtilisateurDTO(u))
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDTO getById(Integer integer) {

        Utilisateur utilisateur = this.utilisateurRepository.findById(integer).orElseThrow(() -> new NoSuchElementException("L'utilisateur ' est mort"));
        utilisateur.setCommandes(commandeRepository.findAllByUtilisateur(utilisateur));
        return mapper.toUtilisateurDTO(utilisateur);
    }

    @Override
    public boolean insert(Utilisateur utilisateur) {
        Utilisateur newUtilisateur = this.utilisateurRepository.save(utilisateur);
        return this.utilisateurRepository.findById(newUtilisateur.getId()).isPresent();
    }

    @Override
    public boolean update(Utilisateur utilisateur, Integer integer) {
        Utilisateur old = this.utilisateurRepository.getOne(integer);
        Utilisateur toTest = new Utilisateur(old.getId(),old.getName(),old.getFirstName(),old.getDroitAcces(),old.getPseudo(),old.getMdp(),old.getAdresse(),old.getCommandes());
        utilisateur.setId(integer);
        this.utilisateurRepository.save(utilisateur);
        return !toTest.equals(this.utilisateurRepository.getOne(integer));
    }

    @Override
    public boolean delete(Integer integer) {
        this.utilisateurRepository.deleteById(integer);
        return this.utilisateurRepository.findById(integer).isEmpty();
    }
}
