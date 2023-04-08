package br.com.consulvet.apis.domain.service;

import br.com.consulvet.apis.domain.dto.TutorDTO;
import br.com.consulvet.apis.domain.entity.Tutor;
import br.com.consulvet.apis.domain.exception.EntityNotFoundException;
import br.com.consulvet.apis.domain.mapper.TutorMapperImpl;
import br.com.consulvet.apis.domain.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TutorService extends TutorMapperImpl {

    @Autowired
    private TutorRepository tutorRepository;
    private String massageEntityNotFound = "Não existe um Tutor de ID: ";

    public Tutor save(TutorDTO tutorDTO){
        Tutor tutor = convertDtoToEntity(tutorDTO);
        return tutorRepository.save(tutor);
    }

    public void del(Long tutorId){
        validationDelete(tutorId);
        tutorRepository.deleteById(tutorId);
    }

    public List<Tutor> listAll(){
        return tutorRepository.findAll();
    }

    public Optional<Tutor> list(Long tutorId) {
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new EntityNotFoundException(massageEntityNotFound + tutorId + "."));
        return Optional.ofNullable(tutor);
    }

    public Tutor upd(Long tutorId, TutorDTO tutorDTO) {
        try{
            Optional<Tutor> oldTutor = tutorRepository.findById(tutorId);

            Tutor newTutor = convertDtoToEntity(tutorDTO);
            BeanUtils.copyProperties(newTutor,oldTutor.get(), "id"); // copia as propriedades de um objeto para outro
            return  tutorRepository.save(oldTutor.get());
        }catch (EmptyResultDataAccessException | NoSuchElementException e){
            throw new EntityNotFoundException(massageEntityNotFound + tutorId + ".");
        }

    }

    private void validationDelete(long id) {
        tutorRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(massageEntityNotFound + id + "."));
    }
}

