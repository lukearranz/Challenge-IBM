package org.arranz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProviderRepository {

    private static final String ID_PROVEEDOR = "proveedor_id";
    private static final String NAME = "nombre";
    private static final String FECHA_DE_ALTA = "fecha_de_alta";
    private static final String ID_CLIENTE = "id_cliente";
    private static final String DATABASE_NAME = "proveedores";

    private final MySqlConfig mySqlConfig = new MySqlConfig();

    public List<Provider> getProvidersByClientId(int clientId) throws SQLException, ClassNotFoundException {

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
