package ru.balrom.Aston_rest_servlet_jdbc.mapper;

import ru.balrom.Aston_rest_servlet_jdbc.dto.PersonDTO;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Person;

public class PersonMapper implements Mapper<Person, PersonDTO> {
    @Override
    public Person fromDTO(PersonDTO personDTO) {
        return Person.builder().id(personDTO.getId()).name(personDTO.getName()).surname(personDTO.getSurname())
                .id_car(personDTO.getId_car()).id_apartment(personDTO.getId_apartment()).build();
    }

    @Override
    public PersonDTO toDTO(Person person) {
        return PersonDTO.builder().id(person.getId()).name(person.getName()).surname(person.getSurname())
                .id_car(person.getId_car()).id_apartment(person.getId_apartment()).build();
    }
}
