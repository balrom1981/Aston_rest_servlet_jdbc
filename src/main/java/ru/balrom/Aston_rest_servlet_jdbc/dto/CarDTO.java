package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarDTO {
    private  int id;
    private String brand;
    private String colour;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO carDTO = (CarDTO) o;
        return id == carDTO.id && Objects.equals(brand, carDTO.brand) && Objects.equals(colour, carDTO.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, colour);
    }
}