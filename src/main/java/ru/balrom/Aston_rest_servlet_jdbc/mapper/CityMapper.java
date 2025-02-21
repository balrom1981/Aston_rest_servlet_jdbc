package ru.balrom.Aston_rest_servlet_jdbc.mapper;

import ru.balrom.Aston_rest_servlet_jdbc.dto.CityDto;
import ru.balrom.Aston_rest_servlet_jdbc.entity.City;

public class CityMapper implements Mapper<City, CityDto> {

    @Override
    public City fromDto(CityDto cityDto) {
        return City.builder().id(cityDto.getId()).name(cityDto.getName()).build();
    }

    @Override
    public CityDto toDto(City city) {
        return CityDto.builder().id(city.getId()).name(city.getName()).build();
    }
}
