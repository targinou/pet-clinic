package targ.study.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import targ.study.petclinic.model.Dono;
import targ.study.petclinic.service.DonoService;

@RestController
@RequestMapping(path = "/api/dono")
public class DonoController {

    @Autowired
    private final DonoService donoService;

    public DonoController(DonoService donoService){
        super();
        this.donoService = donoService;
    }

    @PostMapping(value= "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Dono dono){
        Dono donoSalvo = donoService.cadastrar(dono);
        if (donoSalvo != null){
            return new ResponseEntity<>(donoSalvo, HttpStatus.OK);
        }
        return null;
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
