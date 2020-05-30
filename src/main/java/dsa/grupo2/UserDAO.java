package dsa.grupo2;


import dsa.grupo2.models.User;

public interface UserDAO {

    public String addUser(String name, String email, String password);
    public User getUser(String searchField, String value);
    public User updateUser(String newName, String newEmail, String newPassword, String id);
    public String checkLogin(String name, String password);
    public User getUserByName(String name);
}
