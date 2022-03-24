package targ.study.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targ.study.petclinic.models.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> { }
