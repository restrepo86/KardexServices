package co.com.todo.uno.kardex.domain.validation.add.product;

import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.AddProductEmptyPropertiesException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AreNotEmptyPropertiesTest {

    @InjectMocks
    private AreNotEmptyProperties areNotEmptyProperties;

    private ProductValidationsDTO productValidationsDTO;

    @Before
    public void setUp() {
        productValidationsDTO = new ProductValidationsDTO();
        productValidationsDTO.setProductName("Batman");
        productValidationsDTO.setMaximumAmount(98l);
        productValidationsDTO.setMinimumAmount(10l);
        productValidationsDTO.setUnitValue(27000l);
    }

    @Test
    public void shouldValidateAreNotEmptyProperties() throws AddProductEmptyPropertiesException {
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByAllPropertiesNull() throws AddProductEmptyPropertiesException {
        areNotEmptyProperties.validate(new ProductValidationsDTO());
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByUnitValueNull() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setUnitValue(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByUnitValueZero() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setUnitValue(0l);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByProductNameNull() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setProductName(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByProductNameEmpty() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setProductName("");
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMinimumAmountNull() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setMinimumAmount(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMinimumAmountZero() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setMinimumAmount(0l);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMaximumAmountNull() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setMaximumAmount(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = AddProductEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMaximumAmountZero() throws AddProductEmptyPropertiesException {
        productValidationsDTO.setMaximumAmount(0l);
        areNotEmptyProperties.validate(productValidationsDTO);
    }


}
