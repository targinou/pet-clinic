package targ.study.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import targ.study.petclinic.models.Vet;
import targ.study.petclinic.services.VetService;

@RestController
@RequestMapping("/api/vet")
public class VetController {

    @Autowired
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Vet vet){
        Vet vetSalvo = vetService.cadastrar(vet);
        if (vetSalvo != null){
            return new ResponseEntity<>(vetSalvo, HttpStatus.OK);
        }
        return null;
    }



}
