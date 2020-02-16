package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.domain.validation.output.IRegisterOutputValidation;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import co.com.todo.uno.kardex.exceptions.ProductIdExistsEntryException;
import co.com.todo.uno.kardex.exceptions.ProductIdExistsOutputException;
import co.com.todo.uno.kardex.services.ProductServices;

import javax.inject.Inject;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_921;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_941;

public class ProductIdExists implements IRegisterEntryValidation, IRegisterOutputValidation {

    @Inject
    private ProductServices productServices;

    @Override
    public void validate(EntryValidationsDTO entryValidationsDTO) throws ProductIdExistsEntryException {
        if (!productServices.productExists(entryValidationsDTO.getProductId())) {
            throw new ProductIdExistsEntryException(KARDEX_921);
        };
    }

    @Override
    public void validate(OutputValidationsDTO outputValidationsDTO) throws OutputValidationException {
        if (!productServices.productExists(outputValidationsDTO.getProductId())) {
            throw new ProductIdExistsOutputException(KARDEX_941);
        };
    }
}
