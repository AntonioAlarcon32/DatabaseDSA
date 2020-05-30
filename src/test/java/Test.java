import dsa.grupo2.ItemDAOImp;
import dsa.grupo2.SessionImpl;
import dsa.grupo2.TokenDAOImp;
import dsa.grupo2.UserDaoImp;
import dsa.grupo2.models.*;
import dsa.grupo2.util.ObjectHelper;
import dsa.grupo2.util.QueryHelper;
import org.junit.*;

import java.util.HashMap;

public class Test {
    public static User user;

  /*  @BeforeClass
    public static void setup() {
         user = new User("Antonio", "antonio.alarcon@estudiant.upc.edu", "dadada");
    }

    @org.junit.Test
    public void testUser() {
        Assert.assertNotEquals(null, user.getId());
    }

    @org.junit.Test
    public void testDAOadd() {
        UserDaoImp db = new UserDaoImp();
        db.addUser("carlos","carlos.hermoso@estudiant.upc.edu","proyecto");
    }

    @org.junit.Test
    public void testDaoGet() {
        UserDaoImp db = new UserDaoImp();
        User u = db.getUser("ID","jp34jmza");
        Assert.assertEquals(null, u);
        User u2 = db.getUser("ID","BhZBkzOf");
        Assert.assertEquals("Pep", u2.getName());
    }

    @org.junit.Test
    public void testDAOupdate() {
        UserDaoImp db = new UserDaoImp();
        User u = db.getUser("ID", "BhZBkzOf");
        db.updateUser("Juan","Juan.verdu@estudiant.upc.edu","tetetete", "4X3ouwTx");
        u = db.getUser("ID","BhZBkzOf");
        db.updateUser("Pep","jose.verdu@estudiant.upc.edu","proyecto","aaaaaaaa");
        Assert.assertEquals("Pep", u.getName());
    }

    @org.junit.Test
    public void testGetByName() {
        UserDaoImp db = new UserDaoImp();
        User u2 = db.getUserByName("Pep");
        Assert.assertEquals("BhZBkzOf", u2.getId());
        User u3 = db.getUserByName("Manolo");
        Assert.assertEquals(null, u3);
    }

    @org.junit.Test
    public void testLogin() {
        UserDaoImp db = new UserDaoImp();
        String c = db.checkLogin("Antonio","proyecto");
        TokenDAOImp tdb = new TokenDAOImp();
        boolean check = tdb.checkToken(c);
        Assert.assertEquals(true,check);
    }

    @org.junit.Test
    public void testAdminRights() {
        UserDaoImp db = new UserDaoImp();
        TokenDAOImp db2 = new TokenDAOImp();
        String id = db.addUser("Antonio", "antonio.alarcon@estudiant.upc.edu", "dadada" );
        String tokId = db2.addToken(id, "true");
        Assert.assertEquals(true,db2.isAdmin(tokId));
    }
*/
    @org.junit.Test
    public void testGame() {
        Game newGame = new Game("dadadadadada");
        int c = 1;
    }
}
