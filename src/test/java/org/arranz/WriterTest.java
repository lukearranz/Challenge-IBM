package org.arranz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WriterTest {

    private final String HEADERS = "id_proveedor, nombre, fecha_de_alta, id_cliente";

    @InjectMocks
    private Writer writer;

    @Captor
    private ArgumentCaptor<String> captor;

    @Mock
    BufferedWriter bufferedWriter;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        writer = new Writer(bufferedWriter);
    }

    @Test
    void givenAListOfProvidersThenMap() throws IOException {

        Provider provider = new Provider();
        provider.setName("coca-cola");
        provider.setCreationDateTime(new Date(2022, 12, 9));
        provider.setClientId(1);
        provider.setProviderId(5);
        List<Provider> proveedores = Collections.singletonList(provider);

        writer.generateFile(proveedores);

        verify(bufferedWriter , times(2)).append(captor.capture());
        assertEquals(captor.getAllValues().get(0), HEADERS);
        assertTrue(captor.getAllValues().get(1).contains("cola"));
        verify(bufferedWriter , times(1)).close();
    }

    @Test
    void givenAListOfProvidersThenWriterError() throws IOException {

        when(bufferedWriter.append(any())).thenThrow(IOException.class);

        Provider provider = new Provider();
        provider.setName("coca");
        provider.setCreationDateTime(new Date(2022, 12, 9));
        provider.setClientId(1);
        provider.setProviderId(5);
        List<Provider> proveedores = Collections.singletonList(provider);

        boolean response = writer.generateFile(proveedores);

        assertFalse(response);
    }
}