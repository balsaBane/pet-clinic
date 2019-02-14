package com.bakalinda.petclinic.repositories;

import com.bakalinda.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}