package org.arranz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    private final BufferedWriter bufferedWriter;

    public Writer(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public boolean generateFile(List<Provider> providers) {

        StringBuilder stringBuilder = new StringBuilder();
        providers.forEach(provider -> {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(provider);
        });

        try {
            bufferedWriter.append("id_proveedor, nombre, fecha_de_alta, id_cliente");
            bufferedWriter.append(stringBuilder.toString());
            bufferedWriter.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Problema al generar el archivo: " + ex);
            return false;
        }
    }
}
