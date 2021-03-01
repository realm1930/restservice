package be.vdab.restservice.controllers;

import be.vdab.restservice.domain.Filiaal;
import be.vdab.restservice.exceptions.FiliaalNietGevondenException;
import be.vdab.restservice.services.FiliaalService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

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
        return filiaalService.findById(id).orElseThrow(FiliaalNietGevondenException::new);
    }

    @ExceptionHandler(FiliaalNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void filiaalNietGevonden() { }

    @DeleteMapping("{id}")
    void delete(@PathVariable long id){
        filiaalService.delete(id);
    }

    @PostMapping
    void post(@RequestBody @Valid Filiaal filiaal){
        filiaalService.create(filiaal);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String,String> verkeerdeData(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

    @PutMapping("{id}")
    void put(@RequestBody @Valid Filiaal filiaal){
        filiaalService.update(filiaal);
    }

}
