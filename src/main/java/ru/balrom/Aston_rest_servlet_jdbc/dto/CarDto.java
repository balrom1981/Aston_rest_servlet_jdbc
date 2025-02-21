package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarDto {
    private  int id;
    private String brand;
    private String colour;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return id == carDto.id && Objects.equals(brand, carDto.brand) && Objects.equals(colour, carDto.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, colour);
    }
}