package ru.balrom.Aston_rest_servlet_jdbc.mapper;

import ru.balrom.Aston_rest_servlet_jdbc.dto.ApartmentDTO;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Apartment;

public class ApartmentMapper implements Mapper<Apartment, ApartmentDTO> {
    @Override
    public Apartment fromDTO(ApartmentDTO apartmentDTO) {
        return Apartment.builder().id(apartmentDTO.getId()).number_rooms(apartmentDTO.getNumber_rooms())
                .id_city(apartmentDTO.getId_city()).build();
    }

    @Override
    public ApartmentDTO toDTO(Apartment apartment) {
        return ApartmentDTO.builder().id(apartment.getId()).number_rooms(apartment.getNumber_rooms())
                .id_city(apartment.getId_city()).build();
    }
}
