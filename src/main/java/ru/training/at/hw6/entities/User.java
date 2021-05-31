package ru.training.at.hw6.entities;

import lombok.Value;
import ru.training.at.hw6.utils.ConfigReader;

@Value
public class User {

    public static final User JDI_USER = new User(ConfigReader.getProperty("name"),
            ConfigReader.getProperty("password"),
            ConfigReader.getProperty("fullName"));

    String name;
    String password;
    String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
