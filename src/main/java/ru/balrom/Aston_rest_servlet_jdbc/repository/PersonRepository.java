package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository<Person> {
    private final static String SELECTID = "SELECT * FROM person WHERE id=?";
    private final static String SELECTALL = "SELECT * FROM person";
    private final static String INSERT = "INSERT INTO person (name, surname, id_car, id_appartment) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE person SET name=?, surname=?, id_car=?, id_appartment=? WHERE id=?";
    private final static String DELETE = "DELETE FROM person WHERE id=?";

    private final DBConnector connector;

    public PersonRepository() {
        connector = new DBConnector();
    }

    @Override
    public Person get(int id) {
        Person person = null;

        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setIdCar(resultSet.getInt("id_car"));
                person.setIdApartment(resultSet.getInt("id_appartment"));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> getAll() {
        List<Person> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECTALL)) {
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setIdCar(resultSet.getInt("id_car"));
                person.setIdApartment(resultSet.getInt("id_appartment"));
                list.add(person);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Person person) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getIdCar());
            preparedStatement.setInt(4, person.getIdApartment());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Person persont) {

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, persont.getName());
            statement.setString(2, persont.getSurname());
            statement.setInt(3, persont.getIdCar());
            statement.setInt(4, persont.getIdApartment());
            statement.setInt(5, persont.getId());
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
