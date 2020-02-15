package co.com.todo.uno.kardex.mapper;

import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;

public abstract class DomainMapper {

    private DomainMapper() {
        super();
    }

    public static ProductValidationsDTO buildProductValidationsDTO(ProductRequestDTO productRequestDTO) {
        ProductValidationsDTO productValidationsDTO = new ProductValidationsDTO();
        productValidationsDTO.setProductName(productRequestDTO.getProductName());
        productValidationsDTO.setUnitValue(productRequestDTO.getUnitValue());
        productValidationsDTO.setMinimumAmount(productRequestDTO.getMinimumAmount());
        productValidationsDTO.setMaximumAmount(productRequestDTO.getMaximumAmount());
        return productValidationsDTO;
    }


}
