package be.technifutur.Labo3.api.controller;

import be.technifutur.Labo3.model.dtos.FournisseurDTO;
import be.technifutur.Labo3.model.entities.Fournisseur;
import be.technifutur.Labo3.model.services.FournisseurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(path = "/api/fournisseurs")
public class FournisseurApiController implements  RestControllable<Fournisseur, FournisseurDTO,Integer>{

    private final FournisseurService fournisseurService;

    public FournisseurApiController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<FournisseurDTO>> getAll() {
        return ResponseEntity.ok(this.fournisseurService.getAll());
    }


    @Override
    @GetMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<FournisseurDTO> getOne(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.fournisseurService.getById(integer));
    }

    @Override
    @PostMapping
    @CrossOrigin
    public ResponseEntity<Boolean> insert(@Valid @RequestBody Fournisseur fournisseur) {
        return ResponseEntity.ok(this.fournisseurService.insert(fournisseur));
    }

    @Override
    @PutMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> update(@Valid @RequestBody Fournisseur fournisseur, @PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.fournisseurService.update(fournisseur, integer));
    }

    @Override
    @DeleteMapping(path ="/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.fournisseurService.delete(integer));
    }
}
