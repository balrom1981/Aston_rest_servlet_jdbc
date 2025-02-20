package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class PersonDTO {
    private int id;
    private String name;
    private String surname;
    private int id_car;
    private int id_apartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return id == personDTO.id && id_car == personDTO.id_car && id_apartment == personDTO.id_apartment && Objects.equals(name, personDTO.name) && Objects.equals(surname, personDTO.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, id_car, id_apartment);
    }
}