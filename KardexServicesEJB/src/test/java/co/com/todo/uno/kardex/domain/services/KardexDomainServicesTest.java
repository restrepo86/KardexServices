package co.com.todo.uno.kardex.domain.services;

import co.com.todo.uno.kardex.domain.validation.add.product.KardexAddProductValidations;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
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

    private ProductRequestDTO productRequestDTO;

    @Before
    public void setUp() {

        productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Batman");
        productRequestDTO.setUnitValue(50000l);
        productRequestDTO.setMinimumAmount(10l);
        productRequestDTO.setMaximumAmount(60l);

    }

    @Test
    public void shouldRequestValidateBeforeAddProductToInventory() throws EmptyPropertiesException {
        kardexDomainServices.addProduct(productRequestDTO);
        verify(kardexAddProductValidations).execute(any(ProductValidationsDTO.class));
    }

    @Test
    public void shouldBeAddProductToInventory() throws EmptyPropertiesException {
        kardexDomainServices.addProduct(productRequestDTO);
        verify(productServices).addProduct(productRequestDTO);
    }

}
