package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements Repository<Car>{
    private final DBConnector connector;

    public CarRepository() {
        connector = new DBConnector();
    }

    @Override
    public Car get(int id) {
        String query = "SELECT * FROM car WHERE id=?";
        Car car = null;

        try (Connection connection = connector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
        String query = "SELECT * FROM car";
        List<Car> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
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
        String query = "INSERT INTO car (brand, colour) VALUES(?, ?)";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getColour());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Car car) {
        String query = "UPDATE car SET brand=?, colour=? WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
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
        String query = "DELETE FROM car WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
