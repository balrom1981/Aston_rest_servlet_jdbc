package ru.balrom.Aston_rest_servlet_jdbc.service;

import ru.balrom.Aston_rest_servlet_jdbc.dto.PersonDto;
import ru.balrom.Aston_rest_servlet_jdbc.mapper.PersonMapper;
import ru.balrom.Aston_rest_servlet_jdbc.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService implements Service<PersonDto> {
    private final PersonRepository repository;
    private final PersonMapper mapper;

    public PersonService() {
        repository = new PersonRepository();
        mapper = new PersonMapper();
    }

    @Override
    public PersonDto get(int id) {
        return mapper.toDto(repository.get(id));
    }

    @Override
    public List<PersonDto> getAll() {
        return repository.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(PersonDto personDto) {
        repository.save(mapper.fromDto(personDto));
    }

    @Override
    public void update(PersonDto personDto) {
        repository.update(mapper.fromDto(personDto));
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
