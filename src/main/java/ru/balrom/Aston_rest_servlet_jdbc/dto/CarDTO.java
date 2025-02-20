package ru.balrom.Aston_rest_servlet_jdbc.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarDTO {
    private  int id;
    private String model;
    private String colour;
}