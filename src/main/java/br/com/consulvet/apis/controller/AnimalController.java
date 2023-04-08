package br.com.consulvet.apis.controller;

import br.com.consulvet.apis.domain.dto.AnimalDTO;
import br.com.consulvet.apis.domain.entity.Animal;
import br.com.consulvet.apis.domain.exception.EntityNotFoundException;
import br.com.consulvet.apis.domain.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping()
    public List<Animal> listAll(){
        return animalService.listAll();
    }

    @GetMapping("/{animalId}")
    public ResponseEntity<?> list(@PathVariable Long animalId){
        return ResponseEntity.ok().body(animalService.list(animalId));
     }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal add(@RequestBody AnimalDTO animalDTO){
        return animalService.save(animalDTO);
    }

    @PutMapping("/{animalId}")
    public ResponseEntity<?> upd(@PathVariable Long animalId, @RequestBody AnimalDTO animalDTO){
        return ResponseEntity.ok().body(animalService.upd(animalId, animalDTO));
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<?> del(@PathVariable Long animalId){
        try{
            animalService.del(animalId);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
