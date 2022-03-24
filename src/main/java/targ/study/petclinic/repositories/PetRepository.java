package targ.study.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targ.study.petclinic.models.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> { }
