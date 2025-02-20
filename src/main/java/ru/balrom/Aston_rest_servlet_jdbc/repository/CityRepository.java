package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository implements Repository<City>{
    private final DBConnector connector;

    public CityRepository() {
        connector = new DBConnector();
    }

    @Override
    public City get(int id) {
        String query = "SELECT * FROM city WHERE id=?";
        City city = null;

        try (Connection connection = connector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> getAll() {
        String query = "SELECT * FROM city";
        List<City> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                list.add(city);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(City city) {
        String query = "INSERT INTO city (name) VALUES(?)";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(City city) {
        String query = "UPDATE city SET name =? WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getId());
            statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM city WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
