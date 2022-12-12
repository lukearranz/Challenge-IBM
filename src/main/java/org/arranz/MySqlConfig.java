package org.arranz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {

    private final String url = "jdbc:mysql://localhost:3306/challenge_ibm";
    private final String usuario = "root";
    private final String password = "";
    private Connection conectar;

    public Connection connectToDatabase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión Exitosa");
            return conectar;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error al iniciar la Conexión: " + ex.getMessage());
            throw ex;
        }
    }
}
