package ru.balrom.Aston_rest_servlet_jdbc.service;

import ru.balrom.Aston_rest_servlet_jdbc.dto.CarDTO;
import ru.balrom.Aston_rest_servlet_jdbc.mapper.CarMapper;
import ru.balrom.Aston_rest_servlet_jdbc.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CarService implements Service<CarDTO> {
    private final CarRepository carRepository;
    private final CarMapper mapper;

    public CarService() {
        carRepository = new CarRepository();
        mapper = new CarMapper();
    }

    @Override
    public CarDTO get(int id) {
        return mapper.toDTO(carRepository.get(id));
    }

    @Override
    public List<CarDTO> getAll() {
        return carRepository.getAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void save(CarDTO carDTO) {
        carRepository.save(mapper.fromDTO(carDTO));

    }

    @Override
    public void update(CarDTO carDTO) {
        carRepository.update(mapper.fromDTO(carDTO));
    }

    @Override
    public void delete(int id) {
        carRepository.delete(id);
    }
}
