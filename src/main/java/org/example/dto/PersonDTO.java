package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PersonDTO {
    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

}
