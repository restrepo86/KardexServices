package co.com.todo.uno.kardex.domain.validation.add.product;

import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_900;

public class AreNotEmptyProperties implements IAddProductValidation {

    @Override
    public void validate(ProductValidationsDTO productValidationsDTO) throws EmptyPropertiesException {
        
        List<Boolean> existsEmptyProperties = new ArrayList<>();
        existsEmptyProperties.add(StringUtils.isEmpty(productValidationsDTO.getProductName()));
        existsEmptyProperties.add(isEmptyLong(productValidationsDTO.getUnitValue()));
        existsEmptyProperties.add(isEmptyLong(productValidationsDTO.getMinimumAmount()));
        existsEmptyProperties.add(isEmptyLong(productValidationsDTO.getMaximumAmount()));

        boolean itHasEmptyProperties = existsEmptyProperties.stream().anyMatch(Boolean::booleanValue);
        if (itHasEmptyProperties) {
            throw new EmptyPropertiesException(KARDEX_900);
        }

    }

    private boolean isEmptyLong(Long longData) {
        return longData == null || longData.longValue() == 0;
    }

}
