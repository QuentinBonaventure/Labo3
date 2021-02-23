package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.model.dtos.UtilisateurDTO;
import be.technifutur.Labo3.model.entities.Utilisateur;

import java.util.List;

public class UtilisateurRepository implements Crudable<Utilisateur, UtilisateurDTO, Integer>{
    @Override
    public List<UtilisateurDTO> getAll() {
        return null;
    }

    @Override
    public UtilisateurDTO getById(Integer integer) {
        return null;
    }

    @Override
    public boolean insert(Utilisateur utilisateur) {
        return false;
    }

    @Override
    public boolean update(Utilisateur utilisateur, Integer integer) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
