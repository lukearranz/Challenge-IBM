package org.arranz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        ProviderRepository providerRepository = new ProviderRepository();

        Optional<Integer> clientId = getClientIdFromArgs(args);
        if (clientId.isEmpty()) return;

        List<Provider> providers = providerRepository.getProvidersByClientId(clientId.get());

        if (providers.isEmpty()) {
            System.out.println("El cliente no tiene proveedores asignados");
        }
        createWriter().generateFile(providers);
    }

    private static Optional<Integer> getClientIdFromArgs(String[] args) {
        try {
            return Optional.of(Integer.parseInt(args[0]));
        } catch (Exception e) {
            System.out.println("Please send a valid Provider Id");
        }
        return Optional.empty();
    }

    private static Writer createWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("infoProveedores.txt", false);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        return new Writer(bufferWriter);
    }
}
