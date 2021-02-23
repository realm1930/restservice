package be.vdab.restservice.controllers;

import be.vdab.restservice.domain.Filiaal;
import be.vdab.restservice.services.FiliaalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@RestController
@RequestMapping("/filialen")
public class FiliaalController {
    private final FiliaalService filiaalService;

    public FiliaalController(FiliaalService filiaalService) {
        this.filiaalService = filiaalService;
    }

    @GetMapping("{id}")
    Filiaal get(@PathVariable long id){
        return filiaalService.findById(id).get();
    }
}
