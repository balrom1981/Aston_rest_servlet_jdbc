package ru.balrom.Aston_rest_servlet_jdbc.mapper;

import ru.balrom.Aston_rest_servlet_jdbc.dto.CarDTO;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Car;

public class CarMapper implements Mapper<Car, CarDTO>{
    @Override
    public Car fromDTO(CarDTO carDTO) {
        return Car.builder().id(carDTO.getId()).model(carDTO.getModel()).colour(carDTO.getColour()).build();
    }

    @Override
    public CarDTO toDTO(Car car) {
        return CarDTO.builder().id(car.getId()).model(car.getModel()).colour(car.getColour()).build();
    }
}
