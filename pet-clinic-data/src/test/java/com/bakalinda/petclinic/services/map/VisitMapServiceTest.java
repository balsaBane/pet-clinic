package com.bakalinda.petclinic.services.map;

import com.bakalinda.petclinic.model.Owner;
import com.bakalinda.petclinic.model.Pet;
import com.bakalinda.petclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitMapServiceTest {
    VisitMapService visitServiceMap;

    Long visitId = 1l;

    @BeforeEach
    void setUp() {
        Pet pet = new Pet();
        pet.setId(6l);
        Owner owner = new Owner();
        owner.setId(34l);
        pet.setOwner(owner);
        visitServiceMap = new VisitMapService();
        visitServiceMap.save(Visit.builder().id(visitId).pet(pet).build());
    }

    @Test
    void findAll() {
        Set<Visit> visits = visitServiceMap.findAll();
        assertEquals(1, visits.size());

    }

    @Test
    void findById() {
        Visit visit = visitServiceMap.findById(visitId);
        assertEquals(visit.getId(), visitId);
    }


    @Test
    void deleteById() {
        visitServiceMap.deleteById(visitId);
        assertEquals(0, visitServiceMap.findAll().size());
    }

    @Test
    void delete() {
        visitServiceMap.delete(visitServiceMap.findById(visitId));
        assertEquals(0, visitServiceMap.findAll().size());
    }
}