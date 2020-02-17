package co.com.todo.uno.kardex.domain.validation.output;

import co.com.todo.uno.kardex.domain.validation.entry.ProductIdExists;
import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class KardexRegisterOutputValidations {

    @Inject
    private AreNotEmptyPropertiesOutput areNotEmptyPropertiesOutput;

    @Inject
    private ProductIdExists productIdExists;

    @Inject
    private ThereIsInventoryOfProductToSell thereIsInventoryOfProductToSell;

    public void execute(OutputValidationsDTO outputValidationsDTO) throws OutputValidationException {

        List<IRegisterOutputValidation> registerOutputValidations = new ArrayList<>();
        registerOutputValidations.add(areNotEmptyPropertiesOutput);
        registerOutputValidations.add(productIdExists);
        registerOutputValidations.add(thereIsInventoryOfProductToSell);

        for (IRegisterOutputValidation registerOutputValidation: registerOutputValidations) {
            registerOutputValidation.validate(outputValidationsDTO);
        }


    }

}
