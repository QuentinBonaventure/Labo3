package be.technifutur.Labo3.api.controller;

import be.technifutur.Labo3.model.dtos.UtilisateurDTO;
import be.technifutur.Labo3.model.entities.Utilisateur;
import be.technifutur.Labo3.model.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/utilisateurs")
public class UtilisateurApiController implements RestControllable<Utilisateur, UtilisateurDTO, Integer>{

    private final UtilisateurService utilisateurService;

    public UtilisateurApiController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<UtilisateurDTO>> getAll() {
        return ResponseEntity.ok(this.utilisateurService.getAll());
    }

    @Override
    @GetMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<UtilisateurDTO> getOne(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.utilisateurService.getById(integer));
    }

    @Override
    @PostMapping
    @CrossOrigin
    public ResponseEntity<Boolean> insert(@Valid @RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(this.utilisateurService.insert(utilisateur));
    }

    @Override
    @PutMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> update(@Valid @RequestBody Utilisateur utilisateur, @PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.utilisateurService.update(utilisateur, integer));
    }

    @Override
    @DeleteMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer integer) {

        return ResponseEntity.ok(this.utilisateurService.delete(integer));
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Boolean> partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Integer id) throws IllegalAccessException {
        return ResponseEntity.ok(this.utilisateurService.partialUpdate(updates, id));
    }
}
