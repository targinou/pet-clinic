package targ.study.petclinic.services;

import org.springframework.stereotype.Service;
import targ.study.petclinic.exceptions.BadRequestExeption;
import targ.study.petclinic.models.Pet;
import targ.study.petclinic.repositories.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

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

    public Pet atualizar(Integer id, Pet petNovo){
        Optional<Pet> petVelho = petRepository.findById(id);
        if(petVelho.isPresent()){
            Pet pet = petVelho.get();
            pet.setNome(petNovo.getNome());
            pet.setAniversario(petNovo.getAniversario());
            return petRepository.save(pet);
        }
        return null;
    }
}
