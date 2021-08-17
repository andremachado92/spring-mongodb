package com.andremachado.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    private String id;
    private String name;
    private String email;
    private String cellPhone;
}
