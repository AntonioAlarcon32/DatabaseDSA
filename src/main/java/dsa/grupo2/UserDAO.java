package dsa.grupo2;

import dsa.grupo2.models.User;

public interface UserDAO {

    public String addUser(String name, String email, String password);
    public User getUser(String id);
    public void updateUser(String newName, String newEmail, String newPassword);
    public boolean checkLogin(String name, String password);
}
