package targ.study.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import targ.study.petclinic.model.DTO.ResponseDTO;
import targ.study.petclinic.model.Pet;
import targ.study.petclinic.service.PetService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pet")
public class PetController {

    @Autowired
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Pet pet){
        Pet petSalvo = petService.cadastrar(pet);
        if(petSalvo != null){
            return new ResponseEntity<>(petSalvo, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping(value = "/buscar-todos")
    public ResponseEntity<?> buscarTodos(){
        return new ResponseEntity<>(petService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar-por-id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        return new ResponseEntity<>(petService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remover/{id}")
    public ResponseEntity<ResponseDTO<Pet>> remover(@PathVariable Integer id){
        petService.remover(id);
        return new ResponseEntity<>(new ResponseDTO<>(200, List.of("Pet deletado!"), null), HttpStatus.OK);
    }
}
