package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository implements Repository<City>{
    private final static String SELECTID = "SELECT * FROM city WHERE id=?";
    private final static String SELECTALL = "SELECT * FROM city";
    private final static String INSERT = "INSERT INTO city (name) VALUES(?)";
    private final static String UPDATE = "UPDATE city SET name =? WHERE id=?";
    private final static String DELETE  = "DELETE FROM city WHERE id=?";;

    private final DBConnector connector;

    public CityRepository() {
        connector = new DBConnector();
    }

    @Override
    public City get(int id) {

        City city = null;

        try (Connection connection = connector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECTID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
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
        List<City> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECTALL)) {
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
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(City city) {

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getId());
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
