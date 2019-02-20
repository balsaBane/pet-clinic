package com.bakalinda.petclinic.services.map;

import com.bakalinda.petclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTypeServiceMapTest {

    PetTypeMapService petTypeServiceMap;

    Long typeId = 1l;

    @BeforeEach
    void setUp() {
        petTypeServiceMap = new PetTypeMapService();
        petTypeServiceMap.save(PetType.builder().id(typeId).build());
    }

    @Test
    void findAll() {
        Set<PetType> types = petTypeServiceMap.findAll();
        assertEquals(1, types.size());
    }

    @Test
    void findById() {
        PetType type = petTypeServiceMap.findById(typeId);
        assertEquals(type.getId(), typeId);
    }

    @Test
    void save() {
        Long id = 2L;
        PetType pet2 = PetType.builder().id(id).build();
        PetType savedType = petTypeServiceMap.save(pet2);
        assertEquals(id, savedType.getId());
    }

    @Test
    void deleteById() {
        petTypeServiceMap.deleteById(typeId);
        assertEquals(0, petTypeServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petTypeServiceMap.delete(petTypeServiceMap.findById(typeId));
        assertEquals(0, petTypeServiceMap.findAll().size());
    }

}