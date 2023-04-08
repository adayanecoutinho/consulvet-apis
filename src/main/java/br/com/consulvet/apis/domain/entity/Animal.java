package br.com.consulvet.apis.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Data
public class Animal {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //private Image picture;
    //@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    //@JoinColumn(name="id_tutor",referencedColumnName="id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty("id_tutor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tutor tutor;


}
