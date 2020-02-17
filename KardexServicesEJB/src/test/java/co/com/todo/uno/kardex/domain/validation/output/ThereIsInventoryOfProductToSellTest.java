package co.com.todo.uno.kardex.domain.validation.output;

import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.entity.Entry;
import co.com.todo.uno.kardex.entity.Output;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import co.com.todo.uno.kardex.services.EntryServices;
import co.com.todo.uno.kardex.services.OutputServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ThereIsInventoryOfProductToSellTest {

    @InjectMocks
    private ThereIsInventoryOfProductToSell thereIsInventoryOfProductToSell;

    @Mock
    private EntryServices entryServices;

    @Mock
    private OutputServices outputServices;

    private OutputValidationsDTO outputValidationsDTO;
    private List<Entry> entries;
    private List<Output> outputs;

    @Before
    public void setUp() {

        outputValidationsDTO = new OutputValidationsDTO();

        Entry entry = new Entry();
        entry.setAmount(3l);
        Entry entryTwo = new Entry();
        entryTwo.setAmount(5l);

        entries = Arrays.asList(entry, entryTwo);

        Output output = new Output();
        output.setAmount(2l);

        Output outputTwo = new Output();
        outputTwo.setAmount(1l);

        outputs = Arrays.asList(output, outputTwo);

    }

    @Test
    public void shouldValidateThereIsInventoryOfProductToSell() throws OutputValidationException {
        outputValidationsDTO.setAmount(5l);
        when(entryServices.findProductById(outputValidationsDTO.getProductId())).thenReturn(entries);
        when(outputServices.findProductById(outputValidationsDTO.getProductId())).thenReturn(outputs);
        thereIsInventoryOfProductToSell.validate(outputValidationsDTO);
        verify(entryServices).findProductById(outputValidationsDTO.getProductId());
        verify(outputServices).findProductById(outputValidationsDTO.getProductId());
    }

    @Test(expected = OutputValidationException.class)
    public void shouldValidateThereIsInventoryOfProductToSellTestTwo() throws OutputValidationException {
        outputValidationsDTO.setAmount(8l);
        when(entryServices.findProductById(outputValidationsDTO.getProductId())).thenReturn(entries);
        when(outputServices.findProductById(outputValidationsDTO.getProductId())).thenReturn(outputs);
        thereIsInventoryOfProductToSell.validate(outputValidationsDTO);
        verify(entryServices).findProductById(outputValidationsDTO.getProductId());
        verify(outputServices).findProductById(outputValidationsDTO.getProductId());
    }

}
