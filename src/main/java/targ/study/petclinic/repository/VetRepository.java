package targ.study.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targ.study.petclinic.model.Vet;

@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {
}
