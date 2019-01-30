package com.bakalinda.petclinic.bootstrap;

import com.bakalinda.petclinic.model.Owner;
import com.bakalinda.petclinic.model.Vet;
import com.bakalinda.petclinic.services.OwnerService;
import com.bakalinda.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mike");
        owner1.setLastName("Shionda");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstName("John");
        owner2.setLastName("Doe");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Joe");
        vet1.setLastName("Bloke");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Samuel");
        vet2.setLastName("Braxton");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
