package com.andremachado.api.controller;
import com.andremachado.domain.model.Person;
import com.andremachado.domain.service.PersonService;
import com.andremachado.dto.PersonCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Void>create(@Valid @RequestBody PersonCreateDTO dto){
        personService.create(dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{personId}/update")
    public ResponseEntity<Void>update(@PathVariable String personId, @RequestBody PersonCreateDTO dto){
        personService.update(personId,dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok().body(personService.findAll());
    }

}
