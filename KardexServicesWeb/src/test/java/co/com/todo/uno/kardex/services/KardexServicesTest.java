package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.domain.services.KardexDomainServices;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class KardexServicesTest {

    @InjectMocks
    private KardexServices kardexServices;

    @Mock
    private KardexDomainServices kardexDomainServices;

    private ProductRequestDTO productRequestDTO;

    @Test
    public void shouldAddProductToInventory() throws EmptyPropertiesException {
        kardexServices.addProduct(productRequestDTO);
        verify(kardexDomainServices).addProduct(productRequestDTO);
    }

}
