package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApartmentDTO {
    private int id;
    private int number_rooms;
    private int id_city;
}
