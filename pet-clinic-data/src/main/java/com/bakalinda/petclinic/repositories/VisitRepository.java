package com.bakalinda.petclinic.repositories;

import com.bakalinda.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
