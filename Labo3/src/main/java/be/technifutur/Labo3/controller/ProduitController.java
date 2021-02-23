package be.technifutur.Labo3.controller;

import be.technifutur.Labo3.model.services.ProduitService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/produits")
@Slf4j
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }
}
