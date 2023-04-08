package br.com.consulvet.apis.domain.mapper;

import br.com.consulvet.apis.domain.dto.AnimalDTO;
import br.com.consulvet.apis.domain.dto.TutorDTO;
import br.com.consulvet.apis.domain.entity.Animal;
import br.com.consulvet.apis.domain.entity.Tutor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-07T18:53:45-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public Animal convertDtoToEntity(AnimalDTO animalDTO) {
        if ( animalDTO == null ) {
            return null;
        }

        Animal animal = new Animal();

        animal.setTutor( tutorDTOToTutor( animalDTO.getTutor() ) );
        animal.setId( animalDTO.getId() );
        animal.setIsAlive( animalDTO.getIsAlive() );
        animal.setName( animalDTO.getName() );
        animal.setSpecie( animalDTO.getSpecie() );
        animal.setBreed( animalDTO.getBreed() );
        animal.setGender( animalDTO.getGender() );
        animal.setDateBirth( animalDTO.getDateBirth() );
        animal.setCastrated( animalDTO.getCastrated() );
        animal.setTemperament( animalDTO.getTemperament() );
        animal.setCoat( animalDTO.getCoat() );
        animal.setSize( animalDTO.getSize() );
        animal.setRga( animalDTO.getRga() );
        animal.setMicrochip( animalDTO.getMicrochip() );
        animal.setObsCompl( animalDTO.getObsCompl() );
        animal.setObsIntern( animalDTO.getObsIntern() );

        return animal;
    }

    @Override
    public AnimalDTO convertEntityToDTO(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        AnimalDTO.AnimalDTOBuilder animalDTO = AnimalDTO.builder();

        animalDTO.id( animal.getId() );
        animalDTO.isAlive( animal.getIsAlive() );
        animalDTO.name( animal.getName() );
        animalDTO.specie( animal.getSpecie() );
        animalDTO.breed( animal.getBreed() );
        animalDTO.gender( animal.getGender() );
        animalDTO.dateBirth( animal.getDateBirth() );
        animalDTO.castrated( animal.getCastrated() );
        animalDTO.temperament( animal.getTemperament() );
        animalDTO.coat( animal.getCoat() );
        animalDTO.size( animal.getSize() );
        animalDTO.rga( animal.getRga() );
        animalDTO.microchip( animal.getMicrochip() );
        animalDTO.obsCompl( animal.getObsCompl() );
        animalDTO.tutor( tutorToTutorDTO( animal.getTutor() ) );

        return animalDTO.build();
    }

    protected List<Animal> animalDTOListToAnimalList(List<AnimalDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Animal> list1 = new ArrayList<Animal>( list.size() );
        for ( AnimalDTO animalDTO : list ) {
            list1.add( convertDtoToEntity( animalDTO ) );
        }

        return list1;
    }

    protected Tutor tutorDTOToTutor(TutorDTO tutorDTO) {
        if ( tutorDTO == null ) {
            return null;
        }

        Tutor tutor = new Tutor();

        tutor.setId( tutorDTO.getId() );
        tutor.setName( tutorDTO.getName() );
        tutor.setCpf( tutorDTO.getCpf() );
        tutor.setRg( tutorDTO.getRg() );
        tutor.setCellphone( tutorDTO.getCellphone() );
        tutor.setEmail( tutorDTO.getEmail() );
        tutor.setZipCode( tutorDTO.getZipCode() );
        tutor.setAddress( tutorDTO.getAddress() );
        tutor.setNumberAddress( tutorDTO.getNumberAddress() );
        tutor.setComplement( tutorDTO.getComplement() );
        tutor.setNeighborhood( tutorDTO.getNeighborhood() );
        tutor.setCity( tutorDTO.getCity() );
        tutor.setState( tutorDTO.getState() );
        tutor.setObsIntern( tutorDTO.getObsIntern() );
        tutor.setAnimals( animalDTOListToAnimalList( tutorDTO.getAnimals() ) );

        return tutor;
    }

    protected List<AnimalDTO> animalListToAnimalDTOList(List<Animal> list) {
        if ( list == null ) {
            return null;
        }

        List<AnimalDTO> list1 = new ArrayList<AnimalDTO>( list.size() );
        for ( Animal animal : list ) {
            list1.add( convertEntityToDTO( animal ) );
        }

        return list1;
    }

    protected TutorDTO tutorToTutorDTO(Tutor tutor) {
        if ( tutor == null ) {
            return null;
        }

        TutorDTO.TutorDTOBuilder tutorDTO = TutorDTO.builder();

        tutorDTO.id( tutor.getId() );
        tutorDTO.name( tutor.getName() );
        tutorDTO.cpf( tutor.getCpf() );
        tutorDTO.rg( tutor.getRg() );
        tutorDTO.cellphone( tutor.getCellphone() );
        tutorDTO.email( tutor.getEmail() );
        tutorDTO.zipCode( tutor.getZipCode() );
        tutorDTO.address( tutor.getAddress() );
        tutorDTO.numberAddress( tutor.getNumberAddress() );
        tutorDTO.complement( tutor.getComplement() );
        tutorDTO.neighborhood( tutor.getNeighborhood() );
        tutorDTO.city( tutor.getCity() );
        tutorDTO.state( tutor.getState() );
        tutorDTO.obsIntern( tutor.getObsIntern() );
        tutorDTO.animals( animalListToAnimalDTOList( tutor.getAnimals() ) );

        return tutorDTO.build();
    }
}
