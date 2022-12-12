package org.arranz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProviderRepository {

    private final static String ID_PROVEEDOR = "proveedor_id";
    private final static String NAME = "nombre";
    private final static String FECHA_DE_ALTA = "fecha_de_alta";
    private final static String ID_CLIENTE = "id_cliente";
    private final static String DATABASE_NAME = "proveedores";

    private final MySqlConfig mySqlConfig = new MySqlConfig();

    public List<Provider> getProvidersByClientId(int clientId) throws SQLException, ClassNotFoundException {
        // check string format last value change to int
        String statement = String.format("select %s , %s , %s , %s from %s where id_cliente= %s",
                ID_PROVEEDOR, NAME, FECHA_DE_ALTA, ID_CLIENTE, DATABASE_NAME, clientId);
        List<Provider> providers = new ArrayList<>();
        try {
            // Get a connection to the database
            Connection connection = mySqlConfig.connectToDatabase();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while (rs.next()) {
                // Create a builder
                Provider provider = new Provider();
                provider.setProviderId(rs.getInt(ID_PROVEEDOR));
                provider.setClientId(rs.getInt(ID_CLIENTE));
                provider.setName(rs.getString(NAME));
                provider.setCreationDateTime(rs.getDate(FECHA_DE_ALTA));
                providers.add(provider);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
        return providers;
    }

}
