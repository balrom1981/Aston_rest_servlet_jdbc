package ru.balrom.Aston_rest_servlet_jdbc.service;

import ru.balrom.Aston_rest_servlet_jdbc.dto.ApartmentDTO;
import ru.balrom.Aston_rest_servlet_jdbc.mapper.ApartmentMapper;
import ru.balrom.Aston_rest_servlet_jdbc.repository.ApartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ApartmentService implements Service<ApartmentDTO>{
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper mapper;

    public ApartmentService() {
        apartmentRepository = new ApartmentRepository();
        mapper = new ApartmentMapper();
    }

    @Override
    public ApartmentDTO get(int id) {
        return mapper.toDTO(apartmentRepository.get(id));
    }

    @Override
    public List<ApartmentDTO> getAll() {
        return apartmentRepository.getAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void save(ApartmentDTO apartmentDTO) {
        apartmentRepository.save(mapper.fromDTO(apartmentDTO));
    }

    @Override
    public void update(ApartmentDTO apartmentDTO) {
        apartmentRepository.update(mapper.fromDTO(apartmentDTO));
    }

    @Override
    public void delete(int id) {
        apartmentRepository.delete(id);
    }
}
