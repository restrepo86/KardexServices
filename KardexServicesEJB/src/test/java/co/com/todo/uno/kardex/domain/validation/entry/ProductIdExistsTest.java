package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import co.com.todo.uno.kardex.exceptions.ProductIdExistsEntryException;
import co.com.todo.uno.kardex.exceptions.ProductIdExistsOutputException;
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
    private OutputValidationsDTO outputValidationsDTO;

    @Before
    public void setUp() {
        entryValidationsDTO = new EntryValidationsDTO();
        outputValidationsDTO = new OutputValidationsDTO();
    }

    @Test
    public void shouldValidateProductIdExists() throws ProductIdExistsEntryException {
        when(productServices.productExists(entryValidationsDTO.getProductId())).thenReturn(true);
        productIdExists.validate(entryValidationsDTO);
        verify(productServices).productExists(entryValidationsDTO.getProductId());
    }

    @Test(expected = ProductIdExistsEntryException.class)
    public void shouldValidateProductIdExistsAndThrowExceptionByNotExistsProduct() throws ProductIdExistsEntryException {
        when(productServices.productExists(entryValidationsDTO.getProductId())).thenReturn(false);
        productIdExists.validate(entryValidationsDTO);
        verify(productServices).productExists(entryValidationsDTO.getProductId());
    }

    @Test
    public void shouldValidateProductIdExistsTwo() throws OutputValidationException {
        when(productServices.productExists(outputValidationsDTO.getProductId())).thenReturn(true);
        productIdExists.validate(outputValidationsDTO);
        verify(productServices).productExists(outputValidationsDTO.getProductId());
    }

    @Test(expected = ProductIdExistsOutputException.class)
    public void shouldValidateProductIdExistsAndThrowExceptionByNotExistsProductTwo() throws OutputValidationException {
        when(productServices.productExists(outputValidationsDTO.getProductId())).thenReturn(false);
        productIdExists.validate(outputValidationsDTO);
        verify(productServices).productExists(outputValidationsDTO.getProductId());
    }

}
