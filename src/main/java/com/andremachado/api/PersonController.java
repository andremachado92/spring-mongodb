package com.andremachado.api;
import com.andremachado.domain.service.PersonService;
import com.andremachado.dto.PersonCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
