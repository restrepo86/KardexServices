package co.com.todo.uno.kardex.domain.validation.entry;

import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.exceptions.RegisterEntryEmptyPropertiesException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AreNotEmptyPropertiesEntryTest {

    @InjectMocks
    private AreNotEmptyPropertiesEntry areNotEmptyPropertiesEntry;

    @Mock
    private EntryValidationsDTO entryValidationsDTO;

    @Test(expected = RegisterEntryEmptyPropertiesException.class)
    public void shouldValidateAreNotEmptyPropertiesEntry() throws RegisterEntryEmptyPropertiesException {
        areNotEmptyPropertiesEntry.validate(entryValidationsDTO);
    }

}
