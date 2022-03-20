package targ.study.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targ.study.petclinic.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}
