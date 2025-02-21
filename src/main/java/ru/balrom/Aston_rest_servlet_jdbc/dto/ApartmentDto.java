package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApartmentDto {
    private int id;
    private int number_rooms;
    private int id_city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentDto that = (ApartmentDto) o;
        return id == that.id && number_rooms == that.number_rooms && id_city == that.id_city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number_rooms, id_city);
    }
}
