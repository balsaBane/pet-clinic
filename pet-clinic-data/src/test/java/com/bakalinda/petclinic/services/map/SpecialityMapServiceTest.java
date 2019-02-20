package com.bakalinda.petclinic.services.map;

import com.bakalinda.petclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialityMapServiceTest {

    SpecialityMapService specialityServiceMap;

    Long specialityId = 1l;

    @BeforeEach
    void setUp() {
        specialityServiceMap = new SpecialityMapService();
        specialityServiceMap.save(Speciality.builder().id(specialityId).build());
    }

    @Test
    void findAll() {
        Set<Speciality> types = specialityServiceMap.findAll();
        assertEquals(1, types.size());
    }

    @Test
    void findById() {
        Speciality speciality = specialityServiceMap.findById(specialityId);
        assertEquals(speciality.getId(), specialityId);
    }

    @Test
    void save() {
        Long id = 2L;
        Speciality speciality2 = Speciality.builder().id(id).build();
        Speciality savedSpeciality = specialityServiceMap.save(speciality2);
        assertEquals(id, savedSpeciality.getId());
    }

    @Test
    void deleteById() {
        specialityServiceMap.deleteById(specialityId);
        assertEquals(0, specialityServiceMap.findAll().size());
    }

    @Test
    void delete() {
        specialityServiceMap.delete(specialityServiceMap.findById(specialityId));
        assertEquals(0, specialityServiceMap.findAll().size());
    }
}