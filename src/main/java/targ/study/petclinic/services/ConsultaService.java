package targ.study.petclinic.services;

import org.springframework.stereotype.Service;
import targ.study.petclinic.exceptions.BadRequestExeption;
import targ.study.petclinic.models.Consulta;
import targ.study.petclinic.models.Pet;
import targ.study.petclinic.models.StatusConsulta;
import targ.study.petclinic.repositories.ConsultaRepository;

import java.util.Optional;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta cadastrar(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public void remover(Integer id){
        consultaRepository.findById(id);
    }

    public Consulta buscarPorId(Integer id){
        return consultaRepository.findById(id).orElseThrow(()-> new BadRequestExeption("deu ruim"));
    }

    public Consulta atualizar(Integer id, String status){
        Optional<Consulta> consultaAtualizar = consultaRepository.findById(id);
        if(consultaAtualizar.isPresent()){
            Consulta consulta = consultaAtualizar.get();
            consulta.setStatus(StatusConsulta.valueOf(status));

            return consultaRepository.save(consulta);
        }
        return null;
    }

}
