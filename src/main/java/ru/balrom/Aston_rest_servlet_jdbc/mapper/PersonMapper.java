package ru.balrom.Aston_rest_servlet_jdbc.mapper;

import ru.balrom.Aston_rest_servlet_jdbc.dto.PersonDto;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Person;

public class PersonMapper implements Mapper<Person, PersonDto> {
    @Override
    public Person fromDto(PersonDto personDto) {
        return Person.builder().id(personDto.getId()).name(personDto.getName()).surname(personDto.getSurname())
                .id_car(personDto.getId_car()).id_apartment(personDto.getId_apartment()).build();
    }

    @Override
    public PersonDto toDto(Person person) {
        return PersonDto.builder().id(person.getId()).name(person.getName()).surname(person.getSurname())
                .id_car(person.getId_car()).id_apartment(person.getId_apartment()).build();
    }
}
