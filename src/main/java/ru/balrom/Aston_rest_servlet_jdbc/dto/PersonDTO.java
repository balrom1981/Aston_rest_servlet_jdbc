package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class PersonDTO {
    private int id;
    private String name;
    private String surname;
    private int id_car;
    private int id_apartment;
}