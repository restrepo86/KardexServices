package co.com.todo.uno.kardex.domain.validation.output;

import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import co.com.todo.uno.kardex.exceptions.RegisterOutputEmptyPropertiesException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AreNotEmptyPropertiesOutputTest {

    @InjectMocks
    private AreNotEmptyPropertiesOutput areNotEmptyPropertiesOutput;

    private OutputValidationsDTO outputValidationsDTO;

    @Before
    public void setUp() {
        outputValidationsDTO = new OutputValidationsDTO();
        outputValidationsDTO.setProductId(1234l);
        outputValidationsDTO.setAmount(2l);
        outputValidationsDTO.setTotalValue(6l);
        outputValidationsDTO.setUnitValue(3l);
    }

    @Test
    public void shouldValidateAreNotEmptyPropertiesOutput() throws OutputValidationException {
        areNotEmptyPropertiesOutput.validate(outputValidationsDTO);
    }

    @Test(expected = RegisterOutputEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesOutputAndThrowException() throws OutputValidationException {
        areNotEmptyPropertiesOutput.validate(new OutputValidationsDTO());
    }

    @Test(expected = RegisterOutputEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesOutputAndThrowExceptionByAmountZero() throws OutputValidationException {
        outputValidationsDTO.setAmount(0l);
        areNotEmptyPropertiesOutput.validate(outputValidationsDTO);
    }

    @Test(expected = RegisterOutputEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesOutputAndThrowExceptionByUnitValueZero() throws OutputValidationException {
        outputValidationsDTO.setUnitValue(0l);
        areNotEmptyPropertiesOutput.validate(outputValidationsDTO);
    }

    @Test(expected = RegisterOutputEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesOutputAndThrowExceptionByProductIdZero() throws OutputValidationException {
        outputValidationsDTO.setProductId(0l);
        areNotEmptyPropertiesOutput.validate(outputValidationsDTO);
    }

    @Test(expected = RegisterOutputEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesOutputAndThrowExceptionByTotalValueZero() throws OutputValidationException {
        outputValidationsDTO.setTotalValue(0l);
        areNotEmptyPropertiesOutput.validate(outputValidationsDTO);
    }

}
