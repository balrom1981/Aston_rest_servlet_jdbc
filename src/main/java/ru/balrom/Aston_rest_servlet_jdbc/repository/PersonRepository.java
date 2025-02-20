package ru.balrom.Aston_rest_servlet_jdbc.repository;

import ru.balrom.Aston_rest_servlet_jdbc.db.DBConnector;
import ru.balrom.Aston_rest_servlet_jdbc.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository<Person> {
    private final DBConnector connector;

    public PersonRepository() {
        connector = new DBConnector();
    }

    @Override
    public Person get(int id) {
        String query = "SELECT * FROM person WHERE id=?";
        Person person = null;

        try (Connection connection = connector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setId_car(resultSet.getInt("id_car"));
                person.setId_apartment(resultSet.getInt("id_appartment"));
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
        String query = "SELECT * FROM person";
        List<Person> list = new ArrayList<>();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setId_car(resultSet.getInt("id_car"));
                person.setId_apartment(resultSet.getInt("id_appartment"));
                list.add(person);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Person person) {
        String query = "INSERT INTO person (name, surname, id_car, id_appartment) VALUES(?, ?, ?, ?)";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getId_car());
            preparedStatement.setInt(4, person.getId_apartment());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Person persont) {
        String query = "UPDATE person SET name=?, surname=?, id_car=?, id_appartment=? WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, persont.getName());
            statement.setString(2, persont.getSurname());
            statement.setInt(3, persont.getId_car());
            statement.setInt(4, persont.getId_apartment());
            statement.setInt(5, persont.getId());
            statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM person WHERE id=?";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
