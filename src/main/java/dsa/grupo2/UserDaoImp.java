package dsa.grupo2;

import dsa.grupo2.models.*;

import java.util.HashMap;

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
    public User getUser(String searchField, String value) {
        Session session = null;
        User user = new User();
        try {
            session = FactorySession.openSession();
            user= (User)session.get(User.class,searchField, value);
        }
        catch (Exception e) {

        }
        finally {
            session.close();
        }
        return user;
    }

    @Override
    public void updateUser(String newName, String newEmail, String newPassword, String id) {
        Session session = null;
        User user = new User();

        try {
            session = FactorySession.openSession();
            user = (User)session.get(User.class, "ID" , id);

            User newUser = new User(newName, newEmail, newPassword );
            newUser.setId(id);
            newUser.setExp(user.getExp());
            session.update(newUser,id);
        }
        catch (Exception e) {

        }
        finally {
            session.close();
        }
    }



    @Override
    public User getUserByName(String name) {
        Session session = null;
        User user = new User();
        try {
            session = FactorySession.openSession();
            user= (User)session.get(User.class,"name", name);
        }
        catch (Exception e) {

        }
        finally {
            session.close();
        }
        return user;
    }

    @Override
    public String checkLogin(String name, String password) {
        Session session = null;
        HashMap<String, String > params = new HashMap<String, String>();
        params.put("name", name);
        params.put("password",password);
        try {
            session = FactorySession.openSession();
            Integer i = session.count(User.class, params);
            if (i == 1) {
                User u = this.getUserByName(name);
                TokenDAOImp td = new TokenDAOImp();
                String tokId = td.addToken(u.getId(),"false");
                return tokId;
            }
            else
                return "FALSE";
        }
        catch (Exception e) {
            //Log
            return null;
        }
        finally {
            session.close();
        }

    }
}
