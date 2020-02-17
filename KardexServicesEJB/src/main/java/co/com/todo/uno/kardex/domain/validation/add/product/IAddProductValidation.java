package co.com.todo.uno.kardex.domain.validation.add.product;

import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.AddProductEmptyPropertiesException;

public interface IAddProductValidation {

    void validate(ProductValidationsDTO productValidationsDTO) throws AddProductEmptyPropertiesException;

}
