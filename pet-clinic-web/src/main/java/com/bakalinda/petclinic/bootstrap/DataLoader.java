package com.bakalinda.petclinic.bootstrap;

import com.bakalinda.petclinic.services.OwnerService;
import com.bakalinda.petclinic.services.VetService;
import com.bakalinda.petclinic.services.map.OwnerServiceMap;
import com.bakalinda.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
