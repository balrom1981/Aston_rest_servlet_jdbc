package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements Repository<Car>{
    private final static String SELECTID = "SELECT * FROM car WHERE id=?";
    private final static String SELECTALL = "SELECT * FROM car";
    private final static String INSERT = "INSERT INTO car (brand, colour) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE car SET brand=?, colour=? WHERE id=?";
    private final static String DELETE  = "DELETE FROM car WHERE id=?";;

    private final DBConnector connector;

    public CarRepository() {
        connector = new DBConnector();
    }

    @Override
    public Car get(int id) {
        Car car = null;

        try (Connection connection = connector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECTID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setColour(resultSet.getString("colour"));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> getAll() {
        List<Car> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECTALL)) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setColour(resultSet.getString("colour"));
                list.add(car);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Car car) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getColour());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Car car) {

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getColour());
            statement.setInt(3, car.getId());
            statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
