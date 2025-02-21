package ru.balrom.Aston_rest_servlet_jdbc.service;

import ru.balrom.Aston_rest_servlet_jdbc.dto.CityDTO;
import ru.balrom.Aston_rest_servlet_jdbc.mapper.CityMapper;
import ru.balrom.Aston_rest_servlet_jdbc.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CityService implements Service<CityDTO>{
    private final CityRepository cityRepository;
    private final CityMapper mapper;

    public CityService() {
        cityRepository = new CityRepository();
        mapper = new CityMapper();
    }

    @Override
    public CityDTO get(int id) {
        return mapper.toDTO(cityRepository.get(id));
    }

    @Override
    public List<CityDTO> getAll() {
        return cityRepository.getAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void save(CityDTO cityDTO) {
        cityRepository.save(mapper.fromDTO(cityDTO));
    }

    @Override
    public void update(CityDTO cityDTO) {
        cityRepository.update(mapper.fromDTO(cityDTO));
    }

    @Override
    public void delete(int id) {
        cityRepository.delete(id);
    }
}
