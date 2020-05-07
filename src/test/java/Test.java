import dsa.grupo2.ItemDAOImp;
import dsa.grupo2.UserDaoImp;
import dsa.grupo2.models.*;
import dsa.grupo2.util.ObjectHelper;
import dsa.grupo2.util.QueryHelper;
import org.junit.*;

public class Test {
    public static User user;

    @BeforeClass
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
        db.updateUser("Pep","jose.verdu@estudiant.upc.edu","proyecto", "BhZBkzOf");

        u = db.getUser("ID","BhZBkzOf");
        Assert.assertEquals("Pep", u.getName());
    }

    @org.junit.Test
    public void testGetByName() {
        UserDaoImp db = new UserDaoImp();
        User u2 = db.getUserByName("Pep");
        Assert.assertEquals("BhZBkzOf", u2.getId());
    }

    @org.junit.Test
    public void testLogin() {
        UserDaoImp db = new UserDaoImp();
        Boolean goodLogin = db.checkLogin("Pep","proyecto");
        Boolean badLogin = db.checkLogin("Antonio", "dada");
        Boolean errorLogin = db.checkLogin("Marcos","daffa");
        Assert.assertEquals(true, goodLogin);
        Assert.assertEquals(false, badLogin);
        Assert.assertEquals(false, errorLogin);
    }

    @org.junit.Test
    public void testItemGet() {
        ItemDAOImp db = new ItemDAOImp();
        Item i = db.getItemById("kkkkkkkk");
        Assert.assertEquals("mascarilla",i.getName());
    }

}
