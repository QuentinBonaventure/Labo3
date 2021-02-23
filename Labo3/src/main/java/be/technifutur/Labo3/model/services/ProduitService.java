package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.model.dtos.ProduitDTO;
import be.technifutur.Labo3.model.entities.Produit;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements Crudable<Produit, ProduitDTO, Integer>{

    @Override
    public List<ProduitDTO> getAll() {
        return null;
    }

    @Override
    public ProduitDTO getById(Integer integer) {
        return null;
    }

    @Override
    public boolean insert(Produit produit) {
        return false;
    }

    @Override
    public boolean update(Produit produit, Integer integer) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
