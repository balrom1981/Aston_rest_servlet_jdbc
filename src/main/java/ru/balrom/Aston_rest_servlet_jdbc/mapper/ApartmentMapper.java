package ru.balrom.Aston_rest_servlet_jdbc.mapper;

import ru.balrom.Aston_rest_servlet_jdbc.dto.ApartmentDto;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Apartment;

public class ApartmentMapper implements Mapper<Apartment, ApartmentDto> {
    @Override
    public Apartment fromDto(ApartmentDto apartmentDto) {
        return Apartment.builder().id(apartmentDto.getId()).number_rooms(apartmentDto.getNumber_rooms())
                .id_city(apartmentDto.getId_city()).build();
    }

    @Override
    public ApartmentDto toDto(Apartment apartment) {
        return ApartmentDto.builder().id(apartment.getId()).number_rooms(apartment.getNumber_rooms())
                .id_city(apartment.getId_city()).build();
    }
}
