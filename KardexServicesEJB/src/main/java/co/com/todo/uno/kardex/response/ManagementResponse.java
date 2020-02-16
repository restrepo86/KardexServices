package co.com.todo.uno.kardex.response;

import co.com.todo.uno.kardex.dto.KardexHttpResponseDTO;

import javax.ws.rs.core.Response;
import java.util.HashMap;

public final class ManagementResponse {

    public static final String SALIDA_REGISTRADA_EXITOSAMENTE = "Salida registrada exitosamente";
    private static final String NO_SE_PUDO_AGREGAR_ENTRADA_A_INVENTARIO_INTENTE_NUEVAMENTE = "No se pudo agregar entrada a inventario, intente nuevamente";
    private static final String ENTRADA_REGISTRADA_EXITOSAMENTE = "Entrada registrada exitosamente";
    public static final String NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_INTENTE_NUEVAMENTE = "No se pudo agregar producto a inventario, intente nuevamente";
    private static final String PRODUCTO_ALMACENADO_EXITOSAMENTE = "Producto almacenado exitosamente";
    private static final String EL_PRODUCTO_QUE_DESEA_AGREGAR_CONTIENE_PROPIEDADES_VACIAS_O_DE_VALOR_CERO = "El producto que desea agregar, contiene propiedades vacias o de valor cero";
    private static final String LA_ENTRADA_QUE_DESEA_REGISTRAR_POSEE_PROPIEDADES_VACÍAS_O_DE_VALOR_CERO = "La entrada que desea registrar posee propiedades vacías o de valor cero";
    private static final String EL_PRODUCTO_QUE_DESEA_AGREGAR_COMO_ENTRADA_AL_INVENTARIO_NO_EXISTE = "El producto que desea agregar como entrada al inventario no existe";
    private static final String LA_SALIDA_QUE_DESEA_REGISTRAR_POSEE_PROPIEDADES_VACIAS_O_DE_VALOR_CERO = "La salida que desea registrar posee propiedades vacias o de valor cero";
    private static final String EL_PRODUCTO_QUE_DESEA_AGREGAR_COMO_SALIDA_AL_INVENTARIO_NO_EXISTE = "El producto que desea agregar como salida al inventario no existe";

    public static final String KARDEX_700 = "KARDEX_700";
    public static final String KARDEX_701 = "KARDEX_701";
    public static final String KARDEX_702 = "KARDEX_702";

    public static final String KARDEX_900 = "KARDEX_900";
    public static final String KARDEX_920 = "KARDEX_920";
    public static final String KARDEX_921 = "KARDEX_921";
    public static final String KARDEX_940 = "KARDEX_940";
    public static final String KARDEX_941 = "KARDEX_941";

    public static final String KARDEX_800 = "KARDEX_800";
    public static final String KARDEX_801 = "KARDEX_801";
    public static final String KARDEX_803 = "KARDEX_803";

    private static HashMap<String, KardexHttpResponseDTO> validationRegisterOutputResponses;
    private static HashMap<String, KardexHttpResponseDTO> validationAddProductResponses;
    private static HashMap<String, KardexHttpResponseDTO> validationRegisterEntryResponses;
    private static HashMap<String, KardexHttpResponseDTO> errorResponses;
    private static HashMap<String, KardexHttpResponseDTO> successfulAnswers;

    private ManagementResponse() {
        super();
    }

    public static KardexHttpResponseDTO getValidationProductResponse(String codeError) {
        buildErrorResponseAddProductValidations();
        return validationAddProductResponses.get(codeError);
    }

    public static KardexHttpResponseDTO getValidationRegisterEntryResponse(String codeError) {
        buildErrorResponseRegisterEntryValidations();
        return validationRegisterEntryResponses.get(codeError);
    }

    public static KardexHttpResponseDTO getValidationRegisterOutputResponse(String codeError) {
        buildErrorResponseRegisterOutputValidations();
        return validationRegisterOutputResponses.get(codeError);
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
            errorResponses.put(KARDEX_801, new KardexHttpResponseDTO(KARDEX_801, NO_SE_PUDO_AGREGAR_ENTRADA_A_INVENTARIO_INTENTE_NUEVAMENTE, Response.Status.CONFLICT));
        }

    }

    private static void buildSuccessfulAnswers() {

        if (successfulAnswers == null) {
            successfulAnswers = new HashMap<>();
            successfulAnswers.put(KARDEX_700, new KardexHttpResponseDTO(KARDEX_700, PRODUCTO_ALMACENADO_EXITOSAMENTE, Response.Status.CREATED));
            successfulAnswers.put(KARDEX_701, new KardexHttpResponseDTO(KARDEX_701, ENTRADA_REGISTRADA_EXITOSAMENTE, Response.Status.CREATED));
            successfulAnswers.put(KARDEX_702, new KardexHttpResponseDTO(KARDEX_702, SALIDA_REGISTRADA_EXITOSAMENTE, Response.Status.CREATED));
        }

    }

    private static void buildErrorResponseAddProductValidations() {

        if (validationAddProductResponses == null) {
            validationAddProductResponses = new HashMap<>();
            validationAddProductResponses.put(KARDEX_900,
                    new KardexHttpResponseDTO(KARDEX_900, EL_PRODUCTO_QUE_DESEA_AGREGAR_CONTIENE_PROPIEDADES_VACIAS_O_DE_VALOR_CERO, Response.Status.BAD_REQUEST));
        }
    }

    private static void buildErrorResponseRegisterEntryValidations() {

        if (validationRegisterEntryResponses == null) {
            validationRegisterEntryResponses = new HashMap<>();
            validationRegisterEntryResponses.put(KARDEX_920,
                    new KardexHttpResponseDTO(KARDEX_920, LA_ENTRADA_QUE_DESEA_REGISTRAR_POSEE_PROPIEDADES_VACÍAS_O_DE_VALOR_CERO, Response.Status.BAD_REQUEST));
            validationRegisterEntryResponses.put(KARDEX_921,
                    new KardexHttpResponseDTO(KARDEX_921, EL_PRODUCTO_QUE_DESEA_AGREGAR_COMO_ENTRADA_AL_INVENTARIO_NO_EXISTE, Response.Status.BAD_REQUEST));
        }
    }

    private static void buildErrorResponseRegisterOutputValidations() {

        if (validationRegisterOutputResponses == null) {
            validationRegisterOutputResponses = new HashMap<>();
            validationRegisterOutputResponses.put(KARDEX_940,
                    new KardexHttpResponseDTO(KARDEX_940, LA_SALIDA_QUE_DESEA_REGISTRAR_POSEE_PROPIEDADES_VACIAS_O_DE_VALOR_CERO, Response.Status.BAD_REQUEST));
            validationRegisterOutputResponses.put(KARDEX_941,
                    new KardexHttpResponseDTO(KARDEX_941, EL_PRODUCTO_QUE_DESEA_AGREGAR_COMO_SALIDA_AL_INVENTARIO_NO_EXISTE, Response.Status.BAD_REQUEST));
        }
    }

}
