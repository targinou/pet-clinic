package targ.study.petclinic.service;

import org.springframework.stereotype.Service;
import targ.study.petclinic.exceptions.BadRequestExeption;
import targ.study.petclinic.model.Pet;
import targ.study.petclinic.repository.PetRepository;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){this.petRepository = petRepository;}

    public Pet cadastrar(Pet pet){
        return petRepository.save(pet);
    }

    public void remover(Integer id){
        petRepository.deleteById(id);
    }

    public List<Pet> buscarTodos(){
        return petRepository.findAll();
    }

    public Pet buscarPorId(Integer id){
        return petRepository.findById(id).orElseThrow(()-> new BadRequestExeption("deu ruim"));
    }
}
