package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CityDTO {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO cityDTO = (CityDTO) o;
        return id == cityDTO.id && Objects.equals(name, cityDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
