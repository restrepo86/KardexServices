package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.exceptions.KardexRegisterEntryValidationsException;
import co.com.todo.uno.kardex.exceptions.RegisterEntryEmptyPropertiesException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class KardexRegisterEntryValidations {

    @Inject
    private AreNotEmptyPropertiesEntry areNotEmptyPropertiesEmpty;

    @Inject
    private ProductIdExists productIdExist;

    public void execute(EntryValidationsDTO entryValidationsDTO) throws KardexRegisterEntryValidationsException {

        List<IRegisterEntryValidation> registerEntryValidations = new ArrayList<>();
        registerEntryValidations.add(areNotEmptyPropertiesEmpty);
        registerEntryValidations.add(productIdExist);

        for (IRegisterEntryValidation registerEntryValidation: registerEntryValidations) {
            registerEntryValidation.validate(entryValidationsDTO);
        }

    }

}
