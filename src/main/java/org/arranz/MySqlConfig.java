package org.arranz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {

    public Connection connectToDatabase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/challenge_ibm";
            String usuario = "root";
            String password = "";
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            System.out.println("Error al iniciar la Conexión: " + ex.getMessage());
            throw ex;
        }
    }
}
