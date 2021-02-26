package be.technifutur.Labo3.api.controller;

import be.technifutur.Labo3.model.dtos.ProduitDTO;
import be.technifutur.Labo3.model.entities.Produit;
import be.technifutur.Labo3.model.services.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/produits")
public class ProduitApiController  implements RestControllable<Produit, ProduitDTO,Integer> {

    private final ProduitService produitService;

    public ProduitApiController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @Override
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<ProduitDTO>> getAll() {
        return ResponseEntity.ok(this.produitService.getAll());
    }

    @Override
    @GetMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<ProduitDTO> getOne(@PathVariable("id") Integer integer) {

        return ResponseEntity.ok(this.produitService.getById(integer));
    }

    @Override
    @PostMapping
    public ResponseEntity<Boolean> insert(@Valid @RequestBody Produit produit) {

        return ResponseEntity.ok(this.produitService.insert(produit));
    }

    @Override
    @PutMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> update(@Valid @RequestBody Produit produit, @PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.produitService.update(produit, integer));
    }

    @Override
    @DeleteMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer integer) {

        return ResponseEntity.ok(this.produitService.delete(integer));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Boolean> partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Integer id) throws IllegalAccessException {
        return ResponseEntity.ok(this.produitService.partialUpdate(updates, id));
    }
}
