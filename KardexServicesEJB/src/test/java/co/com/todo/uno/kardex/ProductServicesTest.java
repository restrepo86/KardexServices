package co.com.todo.uno.kardex;

import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.entity.Product;
import co.com.todo.uno.kardex.repository.IProductRepository;
import co.com.todo.uno.kardex.services.ProductServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServicesTest {

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

}
