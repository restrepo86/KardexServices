package co.com.todo.uno.kardex.domain.services;

import co.com.todo.uno.kardex.constantes.Errors;
import co.com.todo.uno.kardex.domain.validation.entry.KardexRegisterEntryValidations;
import co.com.todo.uno.kardex.domain.validation.output.KardexRegisterOutputValidations;
import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.KardexHttpResponseDTO;
import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;
import co.com.todo.uno.kardex.exceptions.KardexAddProductValidationsException;
import co.com.todo.uno.kardex.exceptions.KardexRegisterEntryValidationsException;
import co.com.todo.uno.kardex.exceptions.OutputValidationException;
import co.com.todo.uno.kardex.mapper.DomainMapper;
import co.com.todo.uno.kardex.domain.validation.add.product.KardexAddProductValidations;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.response.ManagementResponse;
import co.com.todo.uno.kardex.services.EntryServices;
import co.com.todo.uno.kardex.services.OutputServices;
import co.com.todo.uno.kardex.services.ProductServices;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_700;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_701;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_702;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_800;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_801;

@Stateless
public class KardexDomainServices {

    private static final Logger LOGGER = Logger.getLogger(KardexDomainServices.class);
    public static final String NO_SE_PUDO_AGREGAR_SALIDA_AL_INVENTARIO_POR = "No se pudo agregar salida al inventario por -> ";

    @Inject
    private KardexAddProductValidations kardexAddProductValidations;

    @Inject
    private ProductServices productServices;

    @Inject
    private EntryServices entryServices;

    @Inject
    private KardexRegisterEntryValidations karderRegisterEntryValidations;

    @Inject
    private OutputServices outputServices;

    @Inject
    private KardexRegisterOutputValidations karderRegisterOutputValidations;

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

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public KardexHttpResponseDTO registerEntry(EntryRequestDTO entryRequestDTO) {

        KardexHttpResponseDTO validationRegisterEntryResponse;
        try {
            karderRegisterEntryValidations.execute(DomainMapper.buildRegisterEntryValidationsDTO(entryRequestDTO));
            entryServices.registerEntry(entryRequestDTO);
            validationRegisterEntryResponse = ManagementResponse.getSuccessfulAnswers(KARDEX_701);
        } catch (KardexRegisterEntryValidationsException kardexRegisterEntryValidationsException) {
            validationRegisterEntryResponse = ManagementResponse.getValidationRegisterEntryResponse(kardexRegisterEntryValidationsException.getMessage());
        } catch (Exception exception) {
            LOGGER.error(Errors.NO_SE_PUDO_AGREGAR_ENTRADA_A_INVENTARIO_POR, exception);
            validationRegisterEntryResponse = ManagementResponse.getErrorAnswer(KARDEX_801);
        }
        return validationRegisterEntryResponse;

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public KardexHttpResponseDTO registerOutput(RegisterOutputRequestDTO registerOutputRequestDTO) {
        KardexHttpResponseDTO kardexHttpResponseDTO;
        try {
            karderRegisterOutputValidations.execute(DomainMapper.buildRegisterOutputValidations(registerOutputRequestDTO));
            outputServices.registerOutput(registerOutputRequestDTO);
            kardexHttpResponseDTO = ManagementResponse.getSuccessfulAnswers(KARDEX_702);
        } catch (OutputValidationException outputValidationException) {
            kardexHttpResponseDTO = ManagementResponse.getValidationRegisterOutputResponse(outputValidationException.getMessage());
        } catch (Exception exception) {
            LOGGER.error(NO_SE_PUDO_AGREGAR_SALIDA_AL_INVENTARIO_POR, exception);
            kardexHttpResponseDTO = ManagementResponse.getErrorAnswer(KARDEX_801);
        }
        return kardexHttpResponseDTO;
    }
}
