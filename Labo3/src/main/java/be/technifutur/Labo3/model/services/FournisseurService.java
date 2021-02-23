package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.model.dtos.FournisseurDTO;
import be.technifutur.Labo3.model.entities.Fournisseur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService implements Crudable<Fournisseur, FournisseurDTO,Integer> {
    @Override
    public List<FournisseurDTO> getAll() {
        return null;
    }

    @Override
    public FournisseurDTO getById(Integer integer) {
        return null;
    }

    @Override
    public boolean insert(Fournisseur fournisseur) {
        return false;
    }

    @Override
    public boolean update(Fournisseur fournisseur, Integer integer) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
