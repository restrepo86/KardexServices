package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.exceptions.KardexRegisterEntryValidationsException;
import co.com.todo.uno.kardex.exceptions.RegisterEntryEmptyPropertiesException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class KardexRegisterEntryValidationsTest {

    @InjectMocks
    private KardexRegisterEntryValidations kardexRegisterEntryValidations;

    @Mock
    private AreNotEmptyPropertiesEntry areNotEmptyPropertiesEntry;

    @Mock
    private ProductIdExists productIdExist;

    private EntryValidationsDTO entryValidationsDTO;

    @Before
    public void setUp() {
        entryValidationsDTO = new EntryValidationsDTO();
        entryValidationsDTO.setProductId(1234l);
    }

    @Test
    public void shouldExecuteEntryValidations() throws KardexRegisterEntryValidationsException {
        kardexRegisterEntryValidations.execute(entryValidationsDTO);
        verify(areNotEmptyPropertiesEntry).validate(entryValidationsDTO);
    }

    @Test
    public void shouldValidateProductIdExists() throws KardexRegisterEntryValidationsException {
        kardexRegisterEntryValidations.execute(entryValidationsDTO);
        verify(productIdExist).validate(entryValidationsDTO);
    }

}
