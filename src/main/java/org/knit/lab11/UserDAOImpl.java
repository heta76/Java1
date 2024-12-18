package org.knit.lab11;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public void create(User user) throws SQLException {
        
    }

    @Override
    public User findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public boolean emailExists(String email) throws SQLException {
        return false;
    }
}
