package co.com.todo.uno.kardex.mapper;

import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
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

    public static EntryValidationsDTO buildRegisterEntryValidationsDTO(EntryRequestDTO entryRequestDTO) {
        EntryValidationsDTO entryValidationsDTO = new EntryValidationsDTO();
        entryValidationsDTO.setAmount(entryRequestDTO.getAmount());
        entryValidationsDTO.setProductId(entryRequestDTO.getProductId());
        entryValidationsDTO.setTotalValue(entryRequestDTO.getTotalValue());
        entryValidationsDTO.setUnitValue(entryRequestDTO.getUnitValue());
        return entryValidationsDTO;
    }
}
