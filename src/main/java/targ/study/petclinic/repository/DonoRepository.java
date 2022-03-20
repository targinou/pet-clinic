package targ.study.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targ.study.petclinic.model.Dono;

import java.util.Optional;

@Repository
public interface DonoRepository extends JpaRepository<Dono, Integer> {


}
