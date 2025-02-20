package ru.balrom.Aston_rest_servlet_jdbc.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Person {
    private int id;
    private String name;
    private String surname;
    private int id_car;
    private int id_apartment;
}
