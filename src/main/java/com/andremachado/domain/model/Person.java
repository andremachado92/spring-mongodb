package com.andremachado.domain.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "test")
public class Person {

    @Id
    private String id;
    private String name;
    private String email;
    private String cellPhone;
}
