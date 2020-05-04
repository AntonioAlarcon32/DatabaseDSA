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
        User u = db.getUser("jp34jmza");
        Assert.assertEquals(null, u);
        User u2 = db.getUser("iRsCQY3Z");
        Assert.assertEquals("carlos", u2.getName());
    }

    @org.junit.Test
    public void testDAOupdate() {
        UserDaoImp db = new UserDaoImp();
        User u = db.getUser("BhZBkzOf");
        db.updateUser("Pep","jose.verdu@estudiant.upc.edu","proyecto", "BhZBkzOf");

        u = db.getUser("BhZBkzOf");
        Assert.assertEquals("Pep", u.getName());
    }

}
