package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.exceptions.ProductIdExistsException;
import co.com.todo.uno.kardex.exceptions.RegisterEntryEmptyPropertiesException;
import co.com.todo.uno.kardex.services.ProductServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductIdExistsTest {

    @InjectMocks
    private ProductIdExists productIdExists;

    @Mock
    private ProductServices productServices;

    private EntryValidationsDTO entryValidationsDTO;

    @Before
    public void setUp() {
        entryValidationsDTO = new EntryValidationsDTO();
    }

    @Test
    public void shouldValidateProductIdExists() throws ProductIdExistsException {
        when(productServices.productExists(entryValidationsDTO.getProductId())).thenReturn(true);
        productIdExists.validate(entryValidationsDTO);
        verify(productServices).productExists(entryValidationsDTO.getProductId());
    }

    @Test(expected = ProductIdExistsException.class)
    public void shouldValidateProductIdExistsAndThrowExceptionByNotExistsProduct() throws ProductIdExistsException {
        when(productServices.productExists(entryValidationsDTO.getProductId())).thenReturn(false);
        productIdExists.validate(entryValidationsDTO);
        verify(productServices).productExists(entryValidationsDTO.getProductId());
    }

}
