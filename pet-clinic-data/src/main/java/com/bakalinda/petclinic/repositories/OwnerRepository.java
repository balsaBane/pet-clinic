package com.bakalinda.petclinic.repositories;

import com.bakalinda.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

}
