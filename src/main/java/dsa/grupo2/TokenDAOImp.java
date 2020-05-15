package dsa.grupo2;

import dsa.grupo2.models.Token;
import dsa.grupo2.models.User;

import java.util.HashMap;

public class TokenDAOImp implements TokenDAO {

    @Override
    public String addToken(String userId, String adminRights) {
        Session session = null;
        String userID = null;
        Token t;
        try {
            t = new Token(userId,adminRights);
            session = FactorySession.openSession();
            session.save(t);
            return t.getId();
        }

        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return null;
    }

    @Override
    public void delToken(String id) {

    }

    @Override
    public boolean checkToken(String id) {
        Session session = null;
        String userID = null;
        try {
            session = FactorySession.openSession();
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("id",id);
            Integer count = session.count(Token.class,params);
            if (count == 1)
                return true;
            else
                return false;
        }

        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return false;
    }
}
