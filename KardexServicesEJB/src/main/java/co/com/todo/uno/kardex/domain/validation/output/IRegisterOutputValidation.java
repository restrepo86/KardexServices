package co.com.todo.uno.kardex.domain.validation.output;

import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;

public interface IRegisterOutputValidation {

    void validate(OutputValidationsDTO outputValidationsDTO) throws OutputValidationException;

}
