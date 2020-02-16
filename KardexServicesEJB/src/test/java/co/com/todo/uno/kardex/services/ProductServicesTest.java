package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.entity.Product;
import co.com.todo.uno.kardex.repository.IProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServicesTest {

    public static final long ID = 2l;

    @InjectMocks
    private ProductServices productServices;

    @Mock
    private IProductRepository iProductRepository;

    private ProductRequestDTO productRequestDTO;

    @Before
    public void setUp() {

        productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Batman");
        productRequestDTO.setMaximumAmount(98l);
        productRequestDTO.setMinimumAmount(10l);
        productRequestDTO.setUnitValue(27000l);

    }

    @Test
    public void shouldAddProductToInventory() {
        productServices.addProduct(productRequestDTO);
        verify(iProductRepository).save(any(Product.class));
    }

    @Test
    public void shouldValidateProductExists() {
        when(iProductRepository.exists(ID)).thenReturn(true);
        boolean exists = productServices.productExists(ID);
        assertTrue(exists);
        verify(iProductRepository).exists(ID);
    }

    @Test
    public void shouldValidateProductExistsAndReturnFalseByIdNull() {
        boolean exists = productServices.productExists(null);
        assertFalse(exists);
        verifyZeroInteractions(iProductRepository);
    }

}
