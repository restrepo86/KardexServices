package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.domain.services.KardexDomainServices;
import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.KardexHttpResponseDTO;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;
import co.com.todo.uno.kardex.mapper.response.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KardexServicesTest {

    @InjectMocks
    private KardexServices kardexServices;

    @Mock
    private KardexDomainServices kardexDomainServices;

    @Mock
    private HttpResponse httpResponse;

    private ProductRequestDTO productRequestDTO;
    private KardexHttpResponseDTO kardexHttpResponseDTO;
    private EntryRequestDTO entryRequestDTO;
    private RegisterOutputRequestDTO registerOutputRequestDTO;

    @Test
    public void shouldAddProductToInventory() {
        kardexServices.addProduct(productRequestDTO);
        verify(kardexDomainServices).addProduct(productRequestDTO);
    }

    @Test
    public void shouldBuildHttpResponseWithMessage() {
        when(kardexDomainServices.addProduct(productRequestDTO)).thenReturn(kardexHttpResponseDTO);
        kardexServices.addProduct(productRequestDTO);
        verify(httpResponse).buildResponse(kardexHttpResponseDTO);
    }

    @Test
    public void shouldRegisterEntryToInventory() {
        when(kardexDomainServices.registerEntry(entryRequestDTO)).thenReturn(kardexHttpResponseDTO);
        kardexServices.registerEntry(entryRequestDTO);
        verify(kardexDomainServices).registerEntry(entryRequestDTO);
    }

    @Test
    public void shouldRegisterOutput() {
        kardexServices.registerOutput(registerOutputRequestDTO);
        verify(kardexDomainServices).registerOutput(registerOutputRequestDTO);
    }

}
