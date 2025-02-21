package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentRepository implements Repository<Apartment> {
    private final static String SELECTID = "SELECT * FROM appartment WHERE id=?";
    private final static String SELECTALL = "SELECT * FROM appartment";
    private final static String INSERT ="INSERT INTO appartment (number_rooms, id_city) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE appartment SET number_rooms=?, id_city=? WHERE id=?";
    private final static String DELETE  = "DELETE FROM appartment WHERE id=?";

    private final DBConnector connector;

    public ApartmentRepository() {
        connector = new DBConnector();
    }

    @Override
    public Apartment get(int id) {
        Apartment apartment = null;

        try (Connection connection = connector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECTID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                apartment = new Apartment();
                apartment.setId(resultSet.getInt("id"));
                apartment.setNumberRooms(resultSet.getInt("number_rooms"));
                apartment.setIdCity(resultSet.getInt("id_city"));
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
        List<Apartment> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECTALL)) {
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setId(resultSet.getInt("id"));
                apartment.setNumberRooms(resultSet.getInt("number_rooms"));
                apartment.setIdCity(resultSet.getInt("id_city"));
                list.add(apartment);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Apartment apartment) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, apartment.getNumberRooms());
            preparedStatement.setInt(2, apartment.getIdCity());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Apartment apartment) {


        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, apartment.getNumberRooms());
            statement.setInt(2, apartment.getIdCity());
            statement.setInt(3, apartment.getId());
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
