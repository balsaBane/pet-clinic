package com.bakalinda.petclinic.services;

import com.bakalinda.petclinic.model.Owner;

public interface OwnerService extends CrudService <Owner, Long>{

    Owner findByLastName (String lastName);

}
