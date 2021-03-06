package targ.study.petclinic.services;

import org.springframework.stereotype.Service;
import targ.study.petclinic.exceptions.BadRequestExeption;
import targ.study.petclinic.models.Dono;
import targ.study.petclinic.repositories.DonoRepository;

import java.util.List;

@Service
public class DonoService{

    private final DonoRepository donoRepository;

    public DonoService(DonoRepository donoRepository){
        this.donoRepository = donoRepository;
    }

    public Dono cadastrar(Dono dono){
        return donoRepository.save(dono);
    }

    public void remover(Integer id_pessoa){
        donoRepository.deleteById(id_pessoa);
    }

    public List<Dono> buscarTodos(){
        return donoRepository.findAll();
    }

    public Dono buscar(Integer id){
        return donoRepository.findById(id).orElseThrow(()-> new BadRequestExeption("deu ruim"));
    }
}
