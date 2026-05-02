package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/kdelectronics";
    private static final String USER = "root";
    private static final String PASSWORD = "@Polo100877";

    public static Connection getConexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }

        return con;
    }
}