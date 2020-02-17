package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;
import co.com.todo.uno.kardex.entity.Output;
import co.com.todo.uno.kardex.repository.IOutputRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OutputServicesTest {

    @InjectMocks
    private OutputServices outputServices;

    @Mock
    private IOutputRepository iOutputRepository;

    private Output output;
    private RegisterOutputRequestDTO registerOutputRequestDTO;

    @Before
    public void setUp() {
        registerOutputRequestDTO = new RegisterOutputRequestDTO();
    }

    @Test
    public void shouldRegisterOutput() {
        outputServices.registerOutput(registerOutputRequestDTO);
        verify(iOutputRepository).save(any(Output.class));
    }

    @Test
    public void shouldFindByProductId() {
        outputServices.findProductById(registerOutputRequestDTO.getProductId());
        verify(iOutputRepository).findByProductId(registerOutputRequestDTO.getProductId());
    }

}
