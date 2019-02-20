package com.bakalinda.petclinic.services.map;

import com.bakalinda.petclinic.model.Speciality;
import com.bakalinda.petclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VetServiceMapTest {

    VetServiceMap vetMapService;

    Long vetId = 1l;

    @BeforeEach
    void setUp() {
        //testing save
        Set<Speciality> specialities = new HashSet<>();
        specialities.add(new Speciality());
        vetMapService = new VetServiceMap(new SpecialityMapService());
        vetMapService.save(Vet.builder().id(vetId).specialities(specialities).build());
    }

    @Test
    void findAll() {
        Set<Vet> vets = vetMapService.findAll();
        assertEquals(1, vets.size());
    }

    @Test
    void findById() {
        Vet vet = vetMapService.findById(vetId);
        assertEquals(vet.getId(), vetId);
    }


    @Test
    void deleteById() {
        vetMapService.deleteById(vetId);
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void delete() {
        vetMapService.delete(vetMapService.findById(vetId));
        assertEquals(0, vetMapService.findAll().size());
    }

}