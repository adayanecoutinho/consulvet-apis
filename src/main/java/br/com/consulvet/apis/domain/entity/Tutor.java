package br.com.consulvet.apis.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Tutor {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer cpf;

    private Integer rg;

    private Integer cellphone;

    private String email;

    private Integer zipCode;

    private String address;

    private String numberAddress;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    private String obsIntern;
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Animal> animals = new ArrayList<>();

}
