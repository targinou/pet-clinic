package targ.study.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import targ.study.petclinic.models.Consulta;
import targ.study.petclinic.models.Vet;
import targ.study.petclinic.services.ConsultaService;
import targ.study.petclinic.services.VetService;


@RestController
@RequestMapping("/api/vet")
public class VetController {

    @Autowired
    private final VetService vetService;

    @Autowired
    private final ConsultaService consultaService;

    public VetController(VetService vetService, ConsultaService consultaService) {
        this.vetService = vetService;
        this.consultaService = consultaService;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Vet vet){
        Vet vetSalvo = vetService.cadastrar(vet);
        if (vetSalvo != null){
            return new ResponseEntity<>(vetSalvo, HttpStatus.OK);
        }
        return null;
    }

    @PutMapping(value = "/{idVet}/alterar-status/{idConsulta}")
    public ResponseEntity<?> alterarStatus(@PathVariable Integer idVet, @PathVariable Integer idConsulta, @RequestBody String status){
        Vet vet = vetService.buscaPorId(idVet);
        Consulta consulta = consultaService.buscarPorId(idConsulta);
        if(Boolean.FALSE.equals(vet.equals(consulta.getVet()))){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Consulta consultaAtualizada = consultaService.atualizar(consulta, status);
        return new ResponseEntity<>(consultaAtualizada, HttpStatus.OK);
    }

}
