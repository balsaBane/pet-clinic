package com.bakalinda.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {


    @Builder
    public Pet(Long id, String name, PetType petType, LocalDate birthDate, Set<Visit> visits, Owner owner) {
        this.id = id;
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
        this.visits = visits;
        this.owner = owner;
    }



    @Column(name = "name")
    private String name;


    private PetType petType;

    @Column(name = "birthday")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

}
