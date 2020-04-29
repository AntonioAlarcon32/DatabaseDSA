package dsa.grupo2.models;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private int exp;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = RandomStringUtils.randomAlphanumeric(8);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExp() {
        return exp;
    }

    public String getPassword() {
        return password;
    }
}
