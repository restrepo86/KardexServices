package co.com.todo.uno.kardex.domain.validation.output;

import co.com.todo.uno.kardex.domain.validation.entry.ProductIdExists;
import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class KardexRegisterOutputValidationsTest {

    @InjectMocks
    private KardexRegisterOutputValidations kardexRegisterOutputValidations;

    @Mock
    private AreNotEmptyPropertiesOutput areNotEmptyPropertiesOutput;

    @Mock
    private ProductIdExists productIdExists;

    private OutputValidationsDTO outputValidationsDTO;

    @Test
    public void shouldValidateAreNotEmptyPropertiesRegisterOutput() throws OutputValidationException {
        kardexRegisterOutputValidations.execute(outputValidationsDTO);
        verify(areNotEmptyPropertiesOutput).validate(outputValidationsDTO);
    }

    @Test
    public void shouldValidateProductIdExists() throws OutputValidationException {
        kardexRegisterOutputValidations.execute(outputValidationsDTO);
        verify(productIdExists).validate(outputValidationsDTO);
    }

}
