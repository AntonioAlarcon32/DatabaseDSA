package dsa.grupo2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class FactorySession {
    public static Session openSession() {


        Connection conn = getConnection();

        Session session = new SessionImpl(conn);

        return session;
    }





    private static Connection getConnection() {
        Connection conn = null;

        Properties properties = new Properties();
        String propFileName = "src/main/resources/conexion.properties";

        try {
            FileInputStream fstream = new FileInputStream(propFileName);
            properties.load(fstream);
            fstream.close();
            String nome = properties.getProperty("usename");
            String port = properties.getProperty("port");

            String result = "Company List = " + nome + ", " + port + ", ";

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DSAGame","juninho","1qaz2wsx3edc");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
