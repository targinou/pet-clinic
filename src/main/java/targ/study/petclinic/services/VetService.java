package targ.study.petclinic.services;

import org.springframework.stereotype.Service;
import targ.study.petclinic.exceptions.BadRequestExeption;
import targ.study.petclinic.models.Vet;
import targ.study.petclinic.repositories.VetRepository;

import java.util.List;

@Service
public class VetService {

    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Vet cadastrar(Vet vet){
        return vetRepository.save(vet);
    }

    public void remover(Integer id){
        vetRepository.deleteById(id);
    }

    public List<Vet> buscarTods(){
        return vetRepository.findAll();
    }

    public Vet buscaPorId(Integer id){
        return vetRepository.findById(id).orElseThrow(()-> new BadRequestExeption("deu ruim"));
    }
}
