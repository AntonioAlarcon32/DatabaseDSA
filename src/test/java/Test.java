import dsa.grupo2.UserDaoImp;
import dsa.grupo2.models.*;
import dsa.grupo2.util.ObjectHelper;
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
        System.out.println(user.getId() + user.getName());
    }

    @org.junit.Test
    public void testDAOadd() {
        UserDaoImp db = new UserDaoImp();
        db.addUser("jose","jose.verdu@estudiant.upc.edu","proyecto");
    }

    @org.junit.Test
    public void testDaoGet() {
        UserDaoImp db = new UserDaoImp();
        db.getUser("jp34jmza");
    }



}
