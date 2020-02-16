package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.exceptions.KardexRegisterEntryValidationsException;
import co.com.todo.uno.kardex.exceptions.ProductIdExistsException;
import co.com.todo.uno.kardex.exceptions.RegisterEntryEmptyPropertiesException;

public interface IRegisterEntryValidation {

    void validate(EntryValidationsDTO entryValidationsDTO) throws KardexRegisterEntryValidationsException;

}
