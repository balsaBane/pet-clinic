package com.bakalinda.petclinic.repositories;

import com.bakalinda.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}