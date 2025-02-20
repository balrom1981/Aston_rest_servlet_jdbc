package ru.balrom.Aston_rest_servlet_jdbc.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class City {
    private int id;
    private String name;
}
