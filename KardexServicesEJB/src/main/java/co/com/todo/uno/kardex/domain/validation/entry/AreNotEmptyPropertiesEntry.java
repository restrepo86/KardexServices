package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.exceptions.AddProductEmptyPropertiesException;
import co.com.todo.uno.kardex.exceptions.RegisterEntryEmptyPropertiesException;
import co.com.todo.uno.kardex.response.ManagementResponse;
import co.com.todo.uno.kardex.util.Utils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_900;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_920;

public class AreNotEmptyPropertiesEntry implements IRegisterEntryValidation {

    @Override
    public void validate(EntryValidationsDTO entryValidationsDTO) throws RegisterEntryEmptyPropertiesException {

        List<Boolean> existsEmptyProperties = new ArrayList<>();
        existsEmptyProperties.add(Utils.isEmptyLong(entryValidationsDTO.getAmount()));
        existsEmptyProperties.add(Utils.isEmptyLong(entryValidationsDTO.getProductId()));
        existsEmptyProperties.add(Utils.isEmptyLong(entryValidationsDTO.getTotalValue()));
        existsEmptyProperties.add(Utils.isEmptyLong(entryValidationsDTO.getUnitValue()));

        boolean itHasEmptyProperties = existsEmptyProperties.stream().anyMatch(Boolean::booleanValue);
        if (itHasEmptyProperties) {
            throw new RegisterEntryEmptyPropertiesException(KARDEX_920);
        }


    }

}
