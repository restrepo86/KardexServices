package co.com.todo.uno.kardex.domain.validation.add.product;

import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.AddProductEmptyPropertiesException;
import co.com.todo.uno.kardex.util.Utils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_900;

public class AreNotEmptyProperties implements IAddProductValidation {

    @Override
    public void validate(ProductValidationsDTO productValidationsDTO) throws AddProductEmptyPropertiesException {

        List<Boolean> existsEmptyProperties = new ArrayList<>();
        existsEmptyProperties.add(StringUtils.isEmpty(productValidationsDTO.getProductName()));
        existsEmptyProperties.add(Utils.isEmptyLong(productValidationsDTO.getUnitValue()));
        existsEmptyProperties.add(Utils.isEmptyLong(productValidationsDTO.getMinimumAmount()));
        existsEmptyProperties.add(Utils.isEmptyLong(productValidationsDTO.getMaximumAmount()));

        boolean itHasEmptyProperties = existsEmptyProperties.stream().anyMatch(Boolean::booleanValue);
        if (itHasEmptyProperties) {
            throw new AddProductEmptyPropertiesException(KARDEX_900);
        }

    }


}
