package ru.balrom.Aston_rest_servlet_jdbc.mapper;

public interface Mapper<E,T> {
    E fromDTO (T t);
    T toDTO(E e);
}
