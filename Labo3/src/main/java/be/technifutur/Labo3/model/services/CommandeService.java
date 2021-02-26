package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.model.dtos.CommandeDTO;
import be.technifutur.Labo3.model.entities.Commande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService  implements Crudable<Commande, CommandeDTO, Integer> {

    @Override
    public List<CommandeDTO> getAll() {
        return null;
    }

    @Override
    public CommandeDTO getById(Integer integer) {
        return null;
    }

    @Override
    public boolean insert(Commande commande) {
        return false;
    }

    @Override
    public boolean update(Commande commande, Integer integer) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
