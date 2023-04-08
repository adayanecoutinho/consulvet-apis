package br.com.consulvet.apis.controller;

import br.com.consulvet.apis.domain.dto.TutorDTO;
import br.com.consulvet.apis.domain.entity.Tutor;
import br.com.consulvet.apis.domain.exception.EntityNotFoundException;
import br.com.consulvet.apis.domain.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping()
    public List<Tutor> listAll(){
        return tutorService.listAll();
    }

    @GetMapping("/{tutorId}")
    public ResponseEntity<?> list(@PathVariable Long tutorId){
        return ResponseEntity.ok().body(tutorService.list(tutorId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor add(@RequestBody TutorDTO tutorDTO){
        return tutorService.save(tutorDTO);
    }

    @PutMapping("/{tutorId}")
    public ResponseEntity<?> upd(@PathVariable Long tutorId, @RequestBody TutorDTO tutorDTO){
        return ResponseEntity.ok().body(tutorService.upd(tutorId, tutorDTO));
    }

    @DeleteMapping("/{tutorId}")
    public ResponseEntity<?> del(@PathVariable Long tutorId){
        try{
            tutorService.del(tutorId);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
