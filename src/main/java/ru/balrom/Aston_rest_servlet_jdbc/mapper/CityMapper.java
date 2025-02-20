package ru.balrom.Aston_rest_servlet_jdbc.mapper;

import ru.balrom.Aston_rest_servlet_jdbc.dto.CityDTO;
import ru.balrom.Aston_rest_servlet_jdbc.entity.City;

public class CityMapper implements Mapper<City, CityDTO> {

    @Override
    public City fromDTO(CityDTO cityDTO) {
        return City.builder().id(cityDTO.getId()).name(cityDTO.getName()).build();
    }

    @Override
    public CityDTO toDTO(City city) {
        return CityDTO.builder().id(city.getId()).name(city.getName()).build();
    }
}
