package br.com.consulvet.apis;

import br.com.consulvet.apis.domain.dto.AnimalDTO;
import br.com.consulvet.apis.domain.entity.Animal;
import br.com.consulvet.apis.domain.repository.AnimalRepository;
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
public class AnimalApiTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AnimalRepository animalRepository;

    Animal animal;

    @BeforeAll
    public void iniciar() {
        this.animal = new Animal();
        animal.setName("Alice");
    }

    @Test
    public void insertNewAnimal() {

        Animal animal = new Animal();
        animal.setName("Charlie");

        HttpEntity<Animal> httpEntity = new HttpEntity<>(animal);

        ResponseEntity<AnimalDTO> response = this.testRestTemplate
                .exchange("/animals", HttpMethod.POST, httpEntity, AnimalDTO.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getName(), "Charlie");
    }
    @Test
    public void getAnimals() {

        ResponseEntity<AnimalDTO[]> response = this.testRestTemplate
                .exchange("/animals", HttpMethod.GET, null, AnimalDTO[].class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }



    @Test
    public void getAnimalsById() {
        Animal animalSave = this.animalRepository.save(this.animal);

        ResponseEntity<AnimalDTO> response = this.testRestTemplate
                .exchange("/animals/" + animalSave.getId(), HttpMethod.GET, null, AnimalDTO.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getName(), "Alice");
    }

    @Test
    public void updAnimals() {

        Animal animalSave = this.animalRepository.save(this.animal);

        Animal animalUp = new Animal();
        animalUp.setName("Maria");

        HttpEntity<Animal> httpEntity = new HttpEntity<>(animalUp);

        ResponseEntity<AnimalDTO> response = this.testRestTemplate
                .exchange("/animals/" + animalSave.getId(), HttpMethod.PUT, httpEntity, AnimalDTO.class);


        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getName(),"Maria");
    }

    @Test
    public void delAnimal() {

        Animal animalSave = this.animalRepository.save(this.animal);

        ResponseEntity<Void> response = this.testRestTemplate
                .exchange("/animals/" + animalSave.getId(), HttpMethod.DELETE, null, Void.class);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
