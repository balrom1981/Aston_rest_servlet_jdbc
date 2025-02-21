package ru.balrom.Aston_rest_servlet_jdbc.service;

import ru.balrom.Aston_rest_servlet_jdbc.dto.CityDto;
import ru.balrom.Aston_rest_servlet_jdbc.mapper.CityMapper;
import ru.balrom.Aston_rest_servlet_jdbc.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CityService implements Service<CityDto>{
    private final CityRepository cityRepository;
    private final CityMapper mapper;

    public CityService() {
        cityRepository = new CityRepository();
        mapper = new CityMapper();
    }

    @Override
    public CityDto get(int id) {
        return mapper.toDto(cityRepository.get(id));
    }

    @Override
    public List<CityDto> getAll() {
        return cityRepository.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(CityDto cityDTO) {
        cityRepository.save(mapper.fromDto(cityDTO));
    }

    @Override
    public void update(CityDto cityDTO) {
        cityRepository.update(mapper.fromDto(cityDTO));
    }

    @Override
    public void delete(int id) {
        cityRepository.delete(id);
    }
}
