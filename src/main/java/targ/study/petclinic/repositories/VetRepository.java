package targ.study.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targ.study.petclinic.models.Vet;

@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {
}
