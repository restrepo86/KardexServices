package co.com.todo.uno.kardex.domain.validation.output;

import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.exceptions.RegisterOutputEmptyPropertiesException;
import co.com.todo.uno.kardex.util.Utils;

import java.util.ArrayList;
import java.util.List;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_940;

public class AreNotEmptyPropertiesOutput implements IRegisterOutputValidation {

    @Override
    public void validate(OutputValidationsDTO outputValidationsDTO) throws RegisterOutputEmptyPropertiesException {

        List<Boolean> existsEmptyProperties = new ArrayList<>();
        existsEmptyProperties.add(Utils.isEmptyLong(outputValidationsDTO.getAmount()));
        existsEmptyProperties.add(Utils.isEmptyLong(outputValidationsDTO.getProductId()));
        existsEmptyProperties.add(Utils.isEmptyLong(outputValidationsDTO.getTotalValue()));
        existsEmptyProperties.add(Utils.isEmptyLong(outputValidationsDTO.getUnitValue()));

        boolean itHasEmptyProperties = existsEmptyProperties.stream().anyMatch(Boolean::booleanValue);
        if (itHasEmptyProperties) {
            throw new RegisterOutputEmptyPropertiesException(KARDEX_940);
        }

    }

}
