package org.knit.lab11;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            UserDAO userDAO = new UserDAOImpl(connection);

            UserService userService = new UserService(userDAO);
            System.out.println("Старт программы...");
            Scanner scanner = new Scanner(System.in);
            String selectedOption = "";
            while (!selectedOption.equals("5")) {
                System.out.println("Меню:");
                System.out.println("1. Добавить пользователя");
                System.out.println("2. Показать всех пользователей");
                System.out.println("3. Обновить пользователя");
                System.out.println("4. Удалить пользователя");
                System.out.println("5. Выйти из программы");

                System.out.println("\nВыберите опцию: ");
                selectedOption = scanner.nextLine();

                switch (selectedOption) {
                    case "1":
                        System.out.println("Введите имя пользователя: ");
                        String name = scanner.nextLine();
                        System.out.println("Введите email пользователя: ");
                        String email = scanner.nextLine();

                        userService.registerUser(name, email);
                        System.out.println("Пользователь успешно добавлен");
                        break;

                    case "2":
                        System.out.println("Список пользователей: ");
                        List<User> users = userService.listAllUsers();
                        for (var user : users) {
                            System.out.println(user);
                        }
                        break;

                    case "3":
                        System.out.println("Введите id пользователя: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Введите новое имя пользователя: ");
                        String newName = scanner.nextLine();
                        System.out.println("Введите новый email пользователя: ");
                        String newEmail = scanner.nextLine();

                        userService.updateUser(id, newName, newEmail);
                        break;

                    case "4":
                        System.out.println("Введите id пользователя для удаления: ");
                        int idToDelete = Integer.parseInt(scanner.nextLine());

                        userService.deleteUser(idToDelete);
                        break;

                    case "5":
                        System.out.println("Выход из программы...");
                        break;

                    default:
                        System.out.println("Некорректный ввод. Повторите попытку.");
                        break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//            System.out.println(userDAO.findById(1)); // поиск по индексу
//            userDAO.create(new User(-1, "dzhdth", "dgdh@sh.ru"));
////            System.out.println(userDAO.findById(6)); // поиск по индексу
////              userDAO.delete(8); // удаление
//            User user2 = new User(9, "abobus", "dgdh@sh.ru");
//            userDAO.update(user2);
//            for (User user : userDAO.findAll()){ // вывод всех
//                System.out.println(user);
//            }
    }
}


