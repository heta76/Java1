package org.knit.lab11;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) {
        User user = new User(-1, name, email);
        try {
            userDAO.create(user);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getLocalizedMessage());
        }
    }

    public List<User> listAllUsers() {
        try {
            return userDAO.findAll();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getLocalizedMessage());
        }
        return null;
    }

    public void deleteUser(int id){
        try {
            userDAO.delete(id);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getLocalizedMessage());
        }
    }
    public void updateUser(int id, String newName, String newEmail){
        try {
            userDAO.update(new User(id,newName,newEmail));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getLocalizedMessage());
        }
    }
}
