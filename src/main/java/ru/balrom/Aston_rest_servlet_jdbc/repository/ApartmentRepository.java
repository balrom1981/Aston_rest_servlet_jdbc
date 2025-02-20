package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentRepository implements Repository<Apartment> {
    private final DBConnector connector;

    public ApartmentRepository() {
        connector = new DBConnector();
    }

    @Override
    public Apartment get(int id) {
        String query = "SELECT * FROM appartment WHERE id=?";
        Apartment apartment = null;

        try (Connection connection = connector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                apartment = new Apartment();
                apartment.setId(resultSet.getInt("id"));
                apartment.setNumber_rooms(resultSet.getInt("number_rooms"));
                apartment.setId_city(resultSet.getInt("id_city"));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return apartment;
    }

    @Override
    public List<Apartment> getAll() {
        String query = "SELECT * FROM appartment";
        List<Apartment> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setId(resultSet.getInt("id"));
                apartment.setNumber_rooms(resultSet.getInt("number_rooms"));
                apartment.setId_city(resultSet.getInt("id_city"));
                list.add(apartment);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Apartment apartment) {
        String query = "INSERT INTO appartment (number_rooms, id_city) VALUES(?, ?)";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, apartment.getNumber_rooms());
            preparedStatement.setInt(2, apartment.getId_city());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Apartment apartment) {
        String query = "UPDATE appartment SET number_rooms=?, id_city=? WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, apartment.getNumber_rooms());
            statement.setInt(2, apartment.getId_city());
            statement.setInt(3, apartment.getId());
            statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM appartment WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
