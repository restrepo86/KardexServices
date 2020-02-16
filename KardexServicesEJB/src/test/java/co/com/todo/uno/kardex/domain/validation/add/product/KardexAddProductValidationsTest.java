package co.com.todo.uno.kardex.domain.validation.add.product;

import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
import co.com.todo.uno.kardex.exceptions.KardexAddProductValidationsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class KardexAddProductValidationsTest {

    @InjectMocks
    private KardexAddProductValidations kardexAddProductValidations;

    @Mock
    private AreNotEmptyProperties areNotEmptyProperties;

    private ProductValidationsDTO productValidationsDTO;

    @Before
    public void setUp() {
        productValidationsDTO = new ProductValidationsDTO();
    }

    @Test
    public void shouldValidateProductPropertiesAreNotEmptyBeforeAddToInventory() throws KardexAddProductValidationsException {
        kardexAddProductValidations.execute(productValidationsDTO);
        verify(areNotEmptyProperties).validate(productValidationsDTO);
    }


}
