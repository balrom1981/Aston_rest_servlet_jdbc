package ru.balrom.Aston_rest_servlet_jdbc.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Car {
    private  int id;
    private String brand;
    private String colour;
}
