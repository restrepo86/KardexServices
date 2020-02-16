package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.entity.Entry;
import co.com.todo.uno.kardex.repository.IEntryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EntryServicesTest {

    @InjectMocks
    private EntryServices entryServices;

    @Mock
    private IEntryRepository iEntryRepository;

    private EntryRequestDTO entryRequestDTO;
    private Entry entry;

    @Before
    public void setUp() {
        entryRequestDTO = new EntryRequestDTO();
        entryRequestDTO.setAmount(20l);
        entryRequestDTO.setProductId(1234l);
        entryRequestDTO.setTotalValue(40000l);
        entryRequestDTO.setUnitValue(2000l);
    }

    @Test
    public void shouldRegisterEntry() {
        entryServices.registerEntry(entryRequestDTO);
        verify(iEntryRepository).save(any(Entry.class));
    }

}
