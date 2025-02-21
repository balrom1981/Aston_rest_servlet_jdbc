package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class PersonDto {
    private int id;
    private String name;
    private String surname;
    private int idCar;
    private int idApartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return id == personDto.id && idCar == personDto.idCar && idApartment == personDto.idApartment && Objects.equals(name, personDto.name) && Objects.equals(surname, personDto.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, idCar, idApartment);
    }
}