package com.andremachado.domain.service;
import com.andremachado.domain.model.Person;
import com.andremachado.domain.repository.PersonRepository;
import com.andremachado.dto.PersonCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create(PersonCreateDTO dto){
       personRepository.save(
               Person.builder().
                       name(dto.getName()).
                       email(dto.getEmail()).
                       cellPhone(dto.getCellPhone())
                       .build()
       );
    }
}
