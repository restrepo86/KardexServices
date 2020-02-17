package co.com.todo.uno.kardex.mapper;

import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;

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

    public static OutputValidationsDTO buildRegisterOutputValidations(RegisterOutputRequestDTO registerOutputRequestDTO) {
        OutputValidationsDTO outputValidationsDTO = new OutputValidationsDTO();
        outputValidationsDTO.setAmount(registerOutputRequestDTO.getAmount());
        outputValidationsDTO.setProductId(registerOutputRequestDTO.getProductId());
        outputValidationsDTO.setTotalValue(registerOutputRequestDTO.getTotalValue());
        outputValidationsDTO.setUnitValue(registerOutputRequestDTO.getUnitValue());
        return outputValidationsDTO;
    }
}
