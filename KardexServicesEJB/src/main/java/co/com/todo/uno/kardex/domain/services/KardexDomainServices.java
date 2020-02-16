package co.com.todo.uno.kardex.domain.services;

import co.com.todo.uno.kardex.constantes.Errors;
import co.com.todo.uno.kardex.dto.KardexHttpResponseDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
import co.com.todo.uno.kardex.exceptions.KardexAddProductValidationsException;
import co.com.todo.uno.kardex.mapper.DomainMapper;
import co.com.todo.uno.kardex.domain.validation.add.product.KardexAddProductValidations;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.response.ManagementResponse;
import co.com.todo.uno.kardex.services.ProductServices;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_700;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_800;

@Stateless
public class KardexDomainServices {

    private static final Logger LOGGER = Logger.getLogger(KardexDomainServices.class);

    @Inject
    private KardexAddProductValidations kardexAddProductValidations;

    @Inject
    private ProductServices productServices;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public KardexHttpResponseDTO addProduct(ProductRequestDTO productRequestDTO) {

        KardexHttpResponseDTO kardexHttpResponseDTO;
        try {
            kardexAddProductValidations.execute(DomainMapper.buildProductValidationsDTO(productRequestDTO));
            productServices.addProduct(productRequestDTO);
            kardexHttpResponseDTO = ManagementResponse.getSuccessfulAnswers(KARDEX_700);
        } catch (KardexAddProductValidationsException kardexAddProductValidationsException) {
            kardexHttpResponseDTO = ManagementResponse.getValidationProductResponse(kardexAddProductValidationsException.getMessage());
        } catch (Exception exception) {
            LOGGER.error(Errors.NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_POR, exception);
            kardexHttpResponseDTO = ManagementResponse.getErrorAnswer(KARDEX_800);
        }

        return kardexHttpResponseDTO;

    }

}
