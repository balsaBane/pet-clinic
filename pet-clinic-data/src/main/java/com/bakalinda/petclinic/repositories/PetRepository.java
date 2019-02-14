package com.bakalinda.petclinic.repositories;

import com.bakalinda.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
