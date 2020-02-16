package co.com.todo.uno.kardex.domain.validation.add.product;

import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
import co.com.todo.uno.kardex.exceptions.KardexAddProductException;
import co.com.todo.uno.kardex.exceptions.KardexAddProductValidationsException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class KardexAddProductValidations {

    @Inject
    private AreNotEmptyProperties areNotEmptyProperties;

    public void execute(ProductValidationsDTO productValidationsDTO) throws KardexAddProductValidationsException {

        List<IAddProductValidation> addProductValidations = new ArrayList<>();
        addProductValidations.add(areNotEmptyProperties);

        for (IAddProductValidation addProductValidation: addProductValidations) {
            addProductValidation.validate(productValidationsDTO);
        }

    }

}
