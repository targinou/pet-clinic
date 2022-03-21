package targ.study.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import targ.study.petclinic.model.Dono;
import targ.study.petclinic.model.Pet;
import targ.study.petclinic.service.DonoService;
import targ.study.petclinic.service.PetService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/dono")
public class DonoController {

    @Autowired
    private final DonoService donoService;
    @Autowired
    private final PetService petService;

    public DonoController(DonoService donoService, PetService petService){
        super();
        this.donoService = donoService;
        this.petService = petService;
    }

    @PostMapping(value= "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Dono dono){
        Dono donoSalvo = donoService.cadastrar(dono);
        if (donoSalvo != null){
            return new ResponseEntity<>(donoSalvo, HttpStatus.OK);
        }
        return null;
    }

    @PostMapping(value = "/cadastrar-pet/{id}")
    public ResponseEntity<?> cadastrarPet(@PathVariable Integer id, @RequestBody Pet pet){
        Dono donoSalvo = donoService.buscar(id);
        pet.setDono(donoSalvo);
        Pet petSalvo = petService.cadastrar(pet);
        List<Pet> ListaPet = donoSalvo.getPets();
        ListaPet.add(petSalvo);
        donoSalvo.setPets(ListaPet);
        this.donoService.cadastrar(donoSalvo);
        return new ResponseEntity<>(petSalvo, HttpStatus.OK);
    }

    @GetMapping(value = "/buscar-todos")
    public ResponseEntity<?> buscarTodos(){
        return new ResponseEntity<>(donoService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar-por-id/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        return new ResponseEntity<>(donoService.buscar(id), HttpStatus.OK);
    }
}
