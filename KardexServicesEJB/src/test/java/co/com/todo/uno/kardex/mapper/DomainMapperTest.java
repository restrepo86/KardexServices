package co.com.todo.uno.kardex.mapper;

import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.EntryValidationsDTO;
import co.com.todo.uno.kardex.dto.OutputValidationsDTO;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.ProductValidationsDTO;
import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DomainMapperTest {

    public static final long UNIT_VALUE = 2000l;
    public static final long TOTAL_VALUE = 20000l;
    public static final long AMOUNT = 10l;
    public static final long PRODUCT_ID = 1234l;
    private ProductRequestDTO productRequestDTO;
    private EntryRequestDTO entryRequestDTO;
    private RegisterOutputRequestDTO registerOutputRequestDTO;

    @Before
    public void setUp() {

        productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Superman");
        productRequestDTO.setMinimumAmount(10l);
        productRequestDTO.setMaximumAmount(80l);
        productRequestDTO.setUnitValue(12300l);

        entryRequestDTO = new EntryRequestDTO();
        entryRequestDTO.setUnitValue(UNIT_VALUE);
        entryRequestDTO.setTotalValue(TOTAL_VALUE);
        entryRequestDTO.setAmount(AMOUNT);
        entryRequestDTO.setProductId(PRODUCT_ID);

        registerOutputRequestDTO = new RegisterOutputRequestDTO();
        registerOutputRequestDTO.setUnitValue(UNIT_VALUE);
        registerOutputRequestDTO.setTotalValue(TOTAL_VALUE);
        registerOutputRequestDTO.setAmount(AMOUNT);
        registerOutputRequestDTO.setProductId(PRODUCT_ID);

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

    @Test
    public void shouldBuildRegisterOutputValidationsDTO() {
        OutputValidationsDTO outputValidationsDTO = DomainMapper.buildRegisterOutputValidations(registerOutputRequestDTO);
        assertEquals(registerOutputRequestDTO.getAmount(), outputValidationsDTO.getAmount());
        assertEquals(registerOutputRequestDTO.getProductId(), outputValidationsDTO.getProductId());
        assertEquals(registerOutputRequestDTO.getTotalValue(), outputValidationsDTO.getTotalValue());
        assertEquals(registerOutputRequestDTO.getUnitValue(), outputValidationsDTO.getUnitValue());
    }

}