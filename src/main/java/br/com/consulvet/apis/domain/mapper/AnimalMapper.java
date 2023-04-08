package br.com.consulvet.apis.domain.mapper;

import br.com.consulvet.apis.domain.dto.AnimalDTO;
import br.com.consulvet.apis.domain.dto.TutorDTO;
import br.com.consulvet.apis.domain.entity.Animal;
import br.com.consulvet.apis.domain.entity.Tutor;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface AnimalMapper {


    //@Mapping(target = "tutor", qualifiedByName = "idTutorDto")
    @Mapping(source = "tutor", target = "tutor")
    Animal convertDtoToEntity(AnimalDTO animalDTO);

    AnimalDTO convertEntityToDTO(Animal animal);

    //  @Mapping(target = "members", source = "members")
    //  CasesDto toDto(CaseEntity entity, List<MemberEntity> members);
  //  @Named("idTutorDto")
 //   Tutor idTutorDtoToTutor(TutorDTO tutorDTO);

}
