package com.bakalinda.petclinic.bootstrap;

import com.bakalinda.petclinic.model.Owner;
import com.bakalinda.petclinic.model.Pet;
import com.bakalinda.petclinic.model.PetType;
import com.bakalinda.petclinic.model.Vet;
import com.bakalinda.petclinic.services.OwnerService;
import com.bakalinda.petclinic.services.PetTypeService;
import com.bakalinda.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog  = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat  = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Shionda");
        owner1.setAddress("123 Road Street");
        owner1.setCity("Boston");
        owner1.setTelephone("151252624");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Doe");
        owner2.setAddress("123 Road Street");
        owner2.setCity("Boston");
        owner2.setTelephone("151252624");

        Pet fiona = new Pet();
        fiona.setPetType(savedCatPetType);
        fiona.setOwner(owner2);
        fiona.setBirthDate(LocalDate.now());
        fiona.setName("Fiona");
        owner2.getPets().add(fiona);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Joe");
        vet1.setLastName("Bloke");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samuel");
        vet2.setLastName("Braxton");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
