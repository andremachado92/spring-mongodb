package com.andremachado.service;

import com.andremachado.domain.service.PersonService;
import com.andremachado.dto.PersonCreateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void should_create_a_person(){
        var dto = new PersonCreateDTO();
        dto.setName("André Cavalcante Machado");
        dto.setEmail("andre@email.com");
        dto.setCellPhone("92-99617-7775");
        personService.create(dto);
    }
}
