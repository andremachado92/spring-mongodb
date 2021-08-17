package com.andremachado.domain.service;
import com.andremachado.api.exception.ObjectNotFoundException;
import com.andremachado.domain.model.Person;
import com.andremachado.domain.repository.PersonRepository;
import com.andremachado.dto.PersonCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(rollbackFor = Exception.class)
    public void update(String personId, PersonCreateDTO dto){
        var currentPerson = findById(personId);
        currentPerson.setName(dto.getName());
        currentPerson.setEmail(dto.getEmail());
        currentPerson.setCellPhone(dto.getCellPhone());
        personRepository.save(currentPerson);
    }

    public Person findById(String personId){
        return personRepository.findById(personId).orElseThrow(()-> new
                ObjectNotFoundException("Pessoa não encontrada na base de dados"));
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
