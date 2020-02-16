package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.exceptions.ProductIdExistsException;
import co.com.todo.uno.kardex.exceptions.RegisterEntryEmptyPropertiesException;
import co.com.todo.uno.kardex.services.ProductServices;

import javax.inject.Inject;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_921;

public class ProductIdExists implements IRegisterEntryValidation {

    @Inject
    private ProductServices productServices;

    @Override
    public void validate(EntryValidationsDTO entryValidationsDTO) throws ProductIdExistsException {
        if (!productServices.productExists(entryValidationsDTO.getProductId())) {
            throw new ProductIdExistsException(KARDEX_921);
        };
    }

}
