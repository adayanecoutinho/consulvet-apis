package br.com.consulvet.apis.domain.dto;

import br.com.consulvet.apis.domain.entity.Tutor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.sql.Date;
@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class AnimalDTO {
    private Long id;
    private Boolean isAlive;
    private String name;

    private String specie;

    private String breed;

    private String gender;

    private Date dateBirth;

    private Boolean castrated;

    private String temperament;

    private String coat;

    private String size;

    private Integer rga;

    private BigDecimal microchip;

    private String obsCompl;

    private String ObsIntern;

    private TutorDTO tutor;

}
