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
    private int numberRooms;
    private int idCity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentDto that = (ApartmentDto) o;
        return id == that.id && numberRooms == that.numberRooms && idCity == that.idCity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberRooms, idCity);
    }
}
