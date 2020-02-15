package co.com.todo.uno.kardex.domain.validation.add.product;

import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
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
    public void shouldValidateAreNotEmptyProperties() throws EmptyPropertiesException {
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByAllPropertiesNull() throws EmptyPropertiesException {
        areNotEmptyProperties.validate(new ProductValidationsDTO());
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByUnitValueNull() throws EmptyPropertiesException {
        productValidationsDTO.setUnitValue(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByUnitValueZero() throws EmptyPropertiesException {
        productValidationsDTO.setUnitValue(0l);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByProductNameNull() throws EmptyPropertiesException {
        productValidationsDTO.setProductName(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByProductNameEmpty() throws EmptyPropertiesException {
        productValidationsDTO.setProductName("");
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMinimumAmountNull() throws EmptyPropertiesException {
        productValidationsDTO.setMinimumAmount(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMinimumAmountZero() throws EmptyPropertiesException {
        productValidationsDTO.setMinimumAmount(0l);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMaximumAmountNull() throws EmptyPropertiesException {
        productValidationsDTO.setMaximumAmount(null);
        areNotEmptyProperties.validate(productValidationsDTO);
    }

    @Test(expected = EmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesAndThrowExceptionByMaximumAmountZero() throws EmptyPropertiesException {
        productValidationsDTO.setMaximumAmount(0l);
        areNotEmptyProperties.validate(productValidationsDTO);
    }


}
