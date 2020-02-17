package co.com.todo.uno.kardex.domain.validation.output;

import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.entity.Entry;
import co.com.todo.uno.kardex.entity.Output;
import co.com.todo.uno.kardex.exceptions.NoInventoryException;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import co.com.todo.uno.kardex.services.EntryServices;
import co.com.todo.uno.kardex.services.OutputServices;

import javax.inject.Inject;
import java.util.List;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_942;

public class ThereIsInventoryOfProductToSell implements IRegisterOutputValidation {

    @Inject
    private EntryServices entryServices;

    @Inject
    private OutputServices outputServices;

    @Override
    public void validate(OutputValidationsDTO outputValidationsDTO) throws OutputValidationException {
        List<Entry> entries = entryServices.findProductById(outputValidationsDTO.getProductId());
        List<Output> outputs = outputServices.findProductById(outputValidationsDTO.getProductId());
        long entriesSum = entries.stream().mapToLong(Entry::getAmount).sum();
        long outputSum = outputs.stream().mapToLong(Output::getAmount).sum();
        long totalProducts = entriesSum - outputSum;
        if (totalProducts < outputValidationsDTO.getAmount()) {
            throw new NoInventoryException(KARDEX_942);
        }
    }

}
