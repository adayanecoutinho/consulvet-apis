package br.com.consulvet.apis.domain.dto;

import br.com.consulvet.apis.domain.entity.Animal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class TutorDTO {
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

    private List<AnimalDTO> animals;
}
