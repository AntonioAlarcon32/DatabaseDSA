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

    public static String[] getPropValues(){

        Properties properties = new Properties();
        String propFileName = "src/main/resources/conexion.properties";

        String vusename = new String();
        String vpassword = new String();
        String vdbclient = new String();
        String vhost = new String();
        String vport = new String();
        String vdatabase = new String();

        String[] result = new String[3];

        try {
            FileInputStream fstream = new FileInputStream(propFileName);
            properties.load(fstream);
            fstream.close();

            vusename = properties.getProperty("usename");
            vport = properties.getProperty("port");
            vpassword = properties.getProperty("password");
            vdatabase = properties.getProperty("database");
            vdbclient = properties.getProperty("dbclient");
            vhost = properties.getProperty("host");

            result[0] = vdbclient+"://"+vhost+":"+vport+"/"+vdatabase;
            result[1] = vusename;
            result[2] = vpassword;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    private static Connection getConnection() {
        Connection conn = null;

        String[] resultado=getPropValues();

        try {
            System.out.println(resultado[0]);

            //conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DSAGame","juninho","1qaz2wsx3edc");
            conn = DriverManager.getConnection(resultado[0],resultado[1],resultado[2]);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
