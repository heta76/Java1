package org.knit.lab11.task24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) throws SQLException {
        String request = "INSERT INTO users (name, email) VALUES (?, ?)";
        if (emailExists(user.getEmail())){
            System.out.println("Пользователь с таким email уже есть");
            return;
        }

        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) throws SQLException {
        String request = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Создание и возврат объекта User
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email")
                    );
                } else {
                    // Пользователь не найден
                    System.out.println("User with id " + id + " not found.");
                    return null;
                }
            }
        }
    }


    @Override
    public List<User> findAll() throws SQLException {
        String request = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(request)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public void update(User user) throws SQLException {
        String request = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        if (findById(user.getId()) != null) {
            try (PreparedStatement statement = connection.prepareStatement(request)) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setInt(3, user.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String request = "DELETE FROM users WHERE id = ?";
        if (findById(id) != null) {
            try (PreparedStatement statement = connection.prepareStatement(request)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean emailExists(String email) throws SQLException {
        String request = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
