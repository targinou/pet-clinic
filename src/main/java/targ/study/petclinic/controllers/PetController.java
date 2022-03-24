package targ.study.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import targ.study.petclinic.models.Consulta;
import targ.study.petclinic.models.DTO.ResponseDTO;
import targ.study.petclinic.models.Pet;
import targ.study.petclinic.models.StatusConsulta;
import targ.study.petclinic.models.Vet;
import targ.study.petclinic.services.ConsultaService;
import targ.study.petclinic.services.PetService;
import targ.study.petclinic.services.VetService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pet")
public class PetController {

    @Autowired
    private final PetService petService;

    @Autowired
    private final ConsultaService consultaService;

    @Autowired
    private final VetService vetService;

    public PetController(PetService petService, ConsultaService consultaService, VetService vetService) {
        this.petService = petService;
        this.consultaService = consultaService;
        this.vetService = vetService;
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

    @PutMapping(value = "/atualizar/{id}")
    public <pet> ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Pet pet){
        Pet petAtualizado = petService.atualizar(id, pet);
        if (petAtualizado != null){
            return new ResponseEntity<>(new ResponseDTO<>(200, List.of("Pet atualizado!"), null), HttpStatus.OK);
        }
        else return new ResponseEntity<>(new ResponseDTO<>(400, List.of("Pet não encontrado!"), null), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/cadastrar-consulta/{idPet}/vet/{idVet}")
    public ResponseEntity<?> cadastrarPet(@PathVariable Integer idPet,@PathVariable Integer idVet, @RequestBody Consulta consulta){
        Pet petSalvo = petService.buscarPorId(idPet);
        Vet vetSalvo = vetService.buscaPorId(idVet);

        consulta.setPet(petSalvo);
        consulta.setVet(vetSalvo);
        consulta.setStatus("Em analise");

        Consulta consultaSalva = consultaService.cadastrar(consulta);
        List<Consulta> ListaConsultasPet = petSalvo.getConsultas();
        ListaConsultasPet.add(consultaSalva);
        petSalvo.setConsultas(ListaConsultasPet);
        this.petService.cadastrar(petSalvo);
        return new ResponseEntity<>(consultaSalva, HttpStatus.OK);
    }
}
