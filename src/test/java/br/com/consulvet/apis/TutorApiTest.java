package br.com.consulvet.apis;

import br.com.consulvet.apis.domain.dto.TutorDTO;
import br.com.consulvet.apis.domain.entity.Tutor;
import br.com.consulvet.apis.domain.repository.TutorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TutorApiTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TutorRepository tutorRepository;

    Tutor tutor;

    @BeforeAll
    public void iniciar() {
        this.tutor = new Tutor();
        tutor.setName("Adayane");
    }

    @Test
    public void insertNewTutor() {

        Tutor tutor = new Tutor();
        tutor.setName("Luelka");

        HttpEntity<Tutor> httpEntity = new HttpEntity<>(tutor);

        ResponseEntity<TutorDTO> response = this.testRestTemplate
                .exchange("/tutors", HttpMethod.POST, httpEntity, TutorDTO.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getName(), "Luelka");
    }
    @Test
    public void getTutors() {

        ResponseEntity<TutorDTO[]> response = this.testRestTemplate
                .exchange("/tutors", HttpMethod.GET, null, TutorDTO[].class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }



    @Test
    public void getTutorsById() {
        Tutor tutorSave = this.tutorRepository.save(this.tutor);

        ResponseEntity<TutorDTO> response = this.testRestTemplate
                .exchange("/tutors/" + tutorSave.getId(), HttpMethod.GET, null, TutorDTO.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getName(), "Adayane");
    }

    @Test
    public void updTutors() {

        Tutor tutorSave = this.tutorRepository.save(this.tutor);

        Tutor tutorUp = new Tutor();
        tutorUp.setName("Luiza");

        HttpEntity<Tutor> httpEntity = new HttpEntity<>(tutorUp);

        ResponseEntity<TutorDTO> response = this.testRestTemplate
                .exchange("/tutors/" + tutorSave.getId(), HttpMethod.PUT, httpEntity, TutorDTO.class);


        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getName(),"Luiza");
    }

    @Test
    public void delTutor() {

        Tutor tutorSave = this.tutorRepository.save(this.tutor);

        ResponseEntity<Void> response = this.testRestTemplate
                .exchange("/tutors/" + tutorSave.getId(), HttpMethod.DELETE, null, Void.class);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
