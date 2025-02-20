package ru.balrom.Aston_rest_servlet_jdbc.service;

import ru.balrom.Aston_rest_servlet_jdbc.dto.PersonDTO;

import java.util.List;

public class PersonService implements Service<PersonDTO> {
    @Override
    public PersonDTO get(int id) {
        return null;
    }

    @Override
    public List<PersonDTO> getAll() {
        return null;
    }

    @Override
    public void save(PersonDTO personDTO) {

    }

    @Override
    public void update(PersonDTO personDTO) {

    }

    @Override
    public void delete(int id) {

    }
}
