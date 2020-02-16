package co.com.todo.uno.kardex.mapper;

import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DomainMapperTest {

    private ProductRequestDTO productRequestDTO;
    private EntryRequestDTO entryRequestDTO;

    @Before
    public void setUp() {

        productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Superman");
        productRequestDTO.setMinimumAmount(10l);
        productRequestDTO.setMaximumAmount(80l);
        productRequestDTO.setUnitValue(12300l);

        entryRequestDTO = new EntryRequestDTO();
        entryRequestDTO.setUnitValue(2000l);
        entryRequestDTO.setTotalValue(20000l);
        entryRequestDTO.setAmount(10l);
        entryRequestDTO.setProductId(1234l);

    }

    @Test
    public void shouldBuildProductValidationsDTO() {
        ProductValidationsDTO productValidationsDTO = DomainMapper.buildProductValidationsDTO(productRequestDTO);
        assertEquals(productRequestDTO.getMaximumAmount().longValue(), productValidationsDTO.getMaximumAmount().longValue());
        assertEquals(productRequestDTO.getMinimumAmount().longValue(), productValidationsDTO.getMinimumAmount().longValue());
        assertEquals(productRequestDTO.getProductName(), productValidationsDTO.getProductName());
        assertEquals(productRequestDTO.getUnitValue(), productValidationsDTO.getUnitValue());
    }

    @Test
    public void shouldBuildRegisterEntryValidationsDTO() {
        EntryValidationsDTO entryValidationsDTO = DomainMapper.buildRegisterEntryValidationsDTO(entryRequestDTO);
        assertEquals(entryRequestDTO.getAmount(), entryValidationsDTO.getAmount());
        assertEquals(entryRequestDTO.getProductId(), entryValidationsDTO.getProductId());
        assertEquals(entryRequestDTO.getTotalValue(), entryValidationsDTO.getTotalValue());
        assertEquals(entryRequestDTO.getUnitValue(), entryValidationsDTO.getUnitValue());
    }

}
