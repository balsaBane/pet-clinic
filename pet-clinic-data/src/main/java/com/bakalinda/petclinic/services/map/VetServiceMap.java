package com.bakalinda.petclinic.services.map;

import com.bakalinda.petclinic.model.Speciality;
import com.bakalinda.petclinic.model.Vet;
import com.bakalinda.petclinic.services.CrudService;
import com.bakalinda.petclinic.services.SpecialityService;
import com.bakalinda.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    private final SpecialityService specialityService;


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object );
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}