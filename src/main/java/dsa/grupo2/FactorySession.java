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

    public static String getPropValues(){

        Properties properties = new Properties();
        String propFileName = "src/main/resources/conexion.properties";

        String vusename = new String();
        String vpassword = new String();
        String vdbclient = new String();
        String vhost = new String();
        String vport = new String();
        String vdatabase = new String();

        String result = new String();

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


            // " jdbc:mariadb : //  localhost : 3306/DSAGame","juninho","1qaz2wsx3edc"
            result = vdbclient+","+vhost+","+","+vhost+","+vport+","+vdatabase+","+vusename+","+vpassword;

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
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

        System.out.println(getPropValues());

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
