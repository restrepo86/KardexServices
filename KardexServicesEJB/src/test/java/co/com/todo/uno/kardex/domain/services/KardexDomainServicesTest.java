package co.com.todo.uno.kardex.domain.services;

import co.com.todo.uno.kardex.domain.validation.add.product.KardexAddProductValidations;
import co.com.todo.uno.kardex.domain.validation.entry.KardexRegisterEntryValidations;
import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.KardexAddProductValidationsException;
import co.com.todo.uno.kardex.exceptions.KardexRegisterEntryValidationsException;
import co.com.todo.uno.kardex.services.EntryServices;
import co.com.todo.uno.kardex.services.ProductServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class KardexDomainServicesTest {

    @InjectMocks
    private KardexDomainServices kardexDomainServices;

    @Mock
    private KardexAddProductValidations kardexAddProductValidations;

    @Mock
    private ProductServices productServices;

    @Mock
    private EntryServices entryServices;

    @Mock
    private KardexRegisterEntryValidations kardexRegisterEntryValidations;

    private ProductRequestDTO productRequestDTO;
    private EntryRequestDTO entryRequestDTO;

    @Before
    public void setUp() {

        productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Batman");
        productRequestDTO.setUnitValue(50000l);
        productRequestDTO.setMinimumAmount(10l);
        productRequestDTO.setMaximumAmount(60l);

        entryRequestDTO = new EntryRequestDTO();
        entryRequestDTO.setProductId(1234l);
        entryRequestDTO.setAmount(2l);
        entryRequestDTO.setTotalValue(4l);
        entryRequestDTO.setUnitValue(2l);

    }

    @Test
    public void shouldRequestValidateBeforeAddProductToInventory() throws KardexAddProductValidationsException {
        kardexDomainServices.addProduct(productRequestDTO);
        verify(kardexAddProductValidations).execute(any(ProductValidationsDTO.class));
    }

    @Test
    public void shouldAddProductToInventory() {
        kardexDomainServices.addProduct(productRequestDTO);
        verify(productServices).addProduct(productRequestDTO);
    }

    @Test
    public void shouldRegisterEntryProductToInventory() {
        kardexDomainServices.registerEntry(entryRequestDTO);
        verify(entryServices).registerEntry(entryRequestDTO);
    }

    @Test
    public void shouldValidateEntryRequest() throws KardexRegisterEntryValidationsException {
        kardexDomainServices.registerEntry(entryRequestDTO);
        verify(kardexRegisterEntryValidations).execute(any(EntryValidationsDTO.class));
    }

}
