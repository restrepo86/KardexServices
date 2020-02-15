package co.com.todo.uno.kardex.mapper;

import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DomainMapperTest {

    private ProductRequestDTO productRequestDTO;

    @Before
    public void setUp() {
        productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Superman");
        productRequestDTO.setMinimumAmount(10l);
        productRequestDTO.setMaximumAmount(80l);
        productRequestDTO.setUnitValue(12300l);
    }

    @Test
    public void shouldBuildProductValidationsDTO() {
        ProductValidationsDTO productValidationsDTO = DomainMapper.buildProductValidationsDTO(productRequestDTO);
        assertEquals(productRequestDTO.getMaximumAmount().longValue(), productValidationsDTO.getMaximumAmount().longValue());
        assertEquals(productRequestDTO.getMinimumAmount().longValue(), productValidationsDTO.getMinimumAmount().longValue());
        assertEquals(productRequestDTO.getProductName(), productValidationsDTO.getProductName());
        assertEquals(productRequestDTO.getUnitValue(), productValidationsDTO.getUnitValue());
    }

}
