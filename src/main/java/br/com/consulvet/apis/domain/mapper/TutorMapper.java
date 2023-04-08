package br.com.consulvet.apis.domain.mapper;

import br.com.consulvet.apis.domain.dto.AnimalDTO;
import br.com.consulvet.apis.domain.dto.TutorDTO;
import br.com.consulvet.apis.domain.entity.Animal;
import br.com.consulvet.apis.domain.entity.Tutor;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.repository.util.ClassUtils.ifPresent;

@Mapper(componentModel = "spring")
public interface TutorMapper {

    @Mappings({
            @Mapping(source = "id", target = "id")
    })
    Tutor convertDtoToEntity(TutorDTO tutorDTO);

    TutorDTO convertEntityToDTO(Tutor tutor);

    @IterableMapping(elementTargetType = AnimalDTO.class)
    List<AnimalDTO> tutorToAnimalsDTO(List<Animal> animalsList);

}
