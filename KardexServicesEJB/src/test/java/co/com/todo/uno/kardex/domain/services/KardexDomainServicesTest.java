package co.com.todo.uno.kardex.domain.services;

import co.com.todo.uno.kardex.domain.validation.add.product.KardexAddProductValidations;
import co.com.todo.uno.kardex.domain.validation.entry.KardexRegisterEntryValidations;
import co.com.todo.uno.kardex.domain.validation.output.KardexRegisterOutputValidations;
import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;
import co.com.todo.uno.kardex.exceptions.KardexAddProductValidationsException;
import co.com.todo.uno.kardex.exceptions.KardexRegisterEntryValidationsException;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import co.com.todo.uno.kardex.services.EntryServices;
import co.com.todo.uno.kardex.services.OutputServices;
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

    public static final long PRODUCT_ID = 1234l;
    public static final long AMOUNT = 2l;
    public static final long TOTAL_VALUE = 4l;
    public static final long UNIT_VALUE = 2l;
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

    @Mock
    private OutputServices outputServices;

    @Mock
    private KardexRegisterOutputValidations kardexRegisterOutputValidations;

    private ProductRequestDTO productRequestDTO;
    private EntryRequestDTO entryRequestDTO;
    private RegisterOutputRequestDTO registerOutputRequestDTO;

    @Before
    public void setUp() {

        productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Batman");
        productRequestDTO.setUnitValue(50000l);
        productRequestDTO.setMinimumAmount(10l);
        productRequestDTO.setMaximumAmount(60l);

        entryRequestDTO = new EntryRequestDTO();
        entryRequestDTO.setProductId(PRODUCT_ID);
        entryRequestDTO.setAmount(AMOUNT);
        entryRequestDTO.setTotalValue(TOTAL_VALUE);
        entryRequestDTO.setUnitValue(UNIT_VALUE);

        registerOutputRequestDTO = new RegisterOutputRequestDTO();
        registerOutputRequestDTO.setProductId(PRODUCT_ID);
        registerOutputRequestDTO.setAmount(AMOUNT);
        registerOutputRequestDTO.setTotalValue(TOTAL_VALUE);
        registerOutputRequestDTO.setUnitValue(UNIT_VALUE);

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

    @Test
    public void shouldRegisterOutputToInventory() {
        kardexDomainServices.registerOutput(registerOutputRequestDTO);
        verify(outputServices).registerOutput(registerOutputRequestDTO);
    }

    @Test
    public void shouldValidateOutputRequestBeforeRegisterOutput() throws OutputValidationException {
        kardexDomainServices.registerOutput(registerOutputRequestDTO);
        verify(kardexRegisterOutputValidations).execute(any(OutputValidationsDTO.class));
    }

}
