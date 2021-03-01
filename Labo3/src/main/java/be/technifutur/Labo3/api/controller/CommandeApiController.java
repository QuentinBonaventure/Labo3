package be.technifutur.Labo3.api.controller;

import be.technifutur.Labo3.model.dtos.CommandeDTO;
import be.technifutur.Labo3.model.entities.Commande;
import be.technifutur.Labo3.model.services.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/commande")
public class CommandeApiController implements RestControllable<Commande, CommandeDTO,Integer> {
    private final CommandeService commandeService;

    public CommandeApiController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @Override
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<CommandeDTO>> getAll() {
        return ResponseEntity.ok(this.commandeService.getAll());
    }

    @Override
    @GetMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<CommandeDTO> getOne(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.commandeService.getById(integer));
    }

    @Override
    @PostMapping
    @CrossOrigin
    public ResponseEntity<Boolean> insert(@Valid @RequestBody Commande commande) {
        return ResponseEntity.ok(this.commandeService.insert(commande));
    }

    @Override
    @PutMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> update(@Valid @RequestBody Commande commande,@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.commandeService.update(commande,integer));
    }

    @Override
    @DeleteMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer integer) {

        return ResponseEntity.ok(this.commandeService.delete(integer));
    }
}
