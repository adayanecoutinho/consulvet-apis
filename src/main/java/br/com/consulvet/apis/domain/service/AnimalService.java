package br.com.consulvet.apis.domain.service;

import br.com.consulvet.apis.domain.dto.AnimalDTO;
import br.com.consulvet.apis.domain.entity.Animal;
import br.com.consulvet.apis.domain.exception.EntityNotFoundException;
import br.com.consulvet.apis.domain.mapper.AnimalMapperImpl;
import br.com.consulvet.apis.domain.repository.AnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AnimalService extends AnimalMapperImpl {
    @Autowired
    private AnimalRepository animalRepository;
    private String massageEntityNotFound = "Não existe um Animal de ID: ";

    public Animal save(AnimalDTO animalDTO){
        Animal animal = convertDtoToEntity(animalDTO);
        try{
            return animalRepository.save(animal);
        }catch (DataIntegrityViolationException e){
            throw new EntityNotFoundException("Cadastro não realizado, pois o Tutor não foi encontrado!");
        }

    }

    public void del(Long animalId){
        validationDelete(animalId);
        animalRepository.deleteById(animalId);
    }

    public List<Animal> listAll(){
        return animalRepository.findAll();
    }

    public Optional<Animal> list(Long animalId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new EntityNotFoundException(massageEntityNotFound + animalId + "."));
        return Optional.ofNullable(animal);
    }

    public Animal upd(Long animalId, AnimalDTO animalDTO) {
        try{
            Optional<Animal> oldAnimal = animalRepository.findById(animalId);

            Animal newAnimal = convertDtoToEntity(animalDTO);

            BeanUtils.copyProperties(newAnimal,oldAnimal.get(), "id"); // copia as propriedades de um objeto para outro
            return  animalRepository.save(oldAnimal.get());
        }catch (EmptyResultDataAccessException | NoSuchElementException e){
            throw new EntityNotFoundException(massageEntityNotFound + animalId + ".");
        }

    }

    private void validationDelete(long id) {
        animalRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(massageEntityNotFound + id + "."));
    }
}
