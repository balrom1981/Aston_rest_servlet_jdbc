package ru.balrom.Aston_rest_servlet_jdbc.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Apartment {
    private int id;
    private int number_rooms;
    private int id_city;
}
