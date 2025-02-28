package org.knit.lab11.task24;

public class User {
    private int id;
    private String name;
    private String email;

    // Конструктор
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Конструктор с параметрами
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Переопределение toString для удобного вывода информации о пользователе
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

