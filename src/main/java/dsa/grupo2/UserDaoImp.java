package dsa.grupo2;

import dsa.grupo2.models.User;

public class UserDaoImp  implements UserDAO{

    @Override
    public String addUser(String name, String email, String password) {
        Session session = null;
        String userID = null;
        try {
            User user = new User(name, email, password);
            session = FactorySession.openSession();
            session.save(user);
            userID = user.getId();
        }

        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return userID;
    }

    @Override
    public User getUser(String id) {
        Session session = null;
        User user = new User();
        try {
            session = FactorySession.openSession();
            session.get(User.class,id);

        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return user;
    }

    @Override
    public void updateUser(String newName, String newEmail, String newPassword) {

    }

    @Override
    public boolean checkLogin(String name, String password) {
        return false;
    }
}
