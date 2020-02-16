package co.com.todo.uno.kardex.response;

import co.com.todo.uno.kardex.dto.KardexHttpResponseDTO;

import javax.ws.rs.core.Response;
import java.util.HashMap;

public final class ManagementResponse {

    private ManagementResponse() {
        super();
    }

    public static final String NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_INTENTE_NUEVAMENTE = "No se pudo agregar producto a inventario, intente nuevamente";
    public static final String PRODUCTO_ALMACENADO_EXITOSAMENTE = "Producto almacenado exitosamente";
    public static final String EL_PRODUCTO_QUE_DESEA_AGREGAR_CONTIENE_PROPIEDADES_VACIAS_O_DE_VALOR_CERO = "El producto que desea agregar, contiene propiedades vacias o de valor cero";

    public static final String KARDEX_700 = "KARDEX_700";
    public static final String KARDEX_900 = "KARDEX_900";
    public static final String KARDEX_800 = "KARDEX_800";

    private static HashMap<String, KardexHttpResponseDTO> validationClientResponses;
    private static HashMap<String, KardexHttpResponseDTO> errorResponses;
    private static HashMap<String, KardexHttpResponseDTO> successfulAnswers;

    public static KardexHttpResponseDTO getValidationProductResponse(String codeError) {
        buildErrorResponseClientValidations();
        return validationClientResponses.get(codeError);
    }

    public static KardexHttpResponseDTO getSuccessfulAnswers(String codeAnswer) {
        buildSuccessfulAnswers();
        return successfulAnswers.get(codeAnswer);
    }

    public static KardexHttpResponseDTO getErrorAnswer(String codeAnswer) {
        buildErrorsAnswers();
        return errorResponses.get(codeAnswer);
    }

    private static void buildErrorsAnswers() {

        if (errorResponses == null) {
            errorResponses = new HashMap<>();
            errorResponses.put(KARDEX_800, new KardexHttpResponseDTO(KARDEX_800, NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_INTENTE_NUEVAMENTE, Response.Status.CONFLICT));
        }

    }

    private static void buildSuccessfulAnswers() {

        if (successfulAnswers == null) {
            successfulAnswers = new HashMap<>();
            successfulAnswers.put(KARDEX_700, new KardexHttpResponseDTO(KARDEX_700, PRODUCTO_ALMACENADO_EXITOSAMENTE, Response.Status.CREATED));
        }

    }

    private static void buildErrorResponseClientValidations() {

        if (validationClientResponses == null) {
            validationClientResponses = new HashMap<>();
            validationClientResponses.put(KARDEX_900,
                    new KardexHttpResponseDTO(KARDEX_900, EL_PRODUCTO_QUE_DESEA_AGREGAR_CONTIENE_PROPIEDADES_VACIAS_O_DE_VALOR_CERO, Response.Status.BAD_REQUEST));
        }
    }

}
