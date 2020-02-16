package co.com.todo.uno.kardex.mapper.response;

import co.com.todo.uno.kardex.constantes.Errors;
import co.com.todo.uno.kardex.dto.KardexHttpResponseDTO;
import co.com.todo.uno.kardex.dto.KardexResponseDTO;
import co.com.todo.uno.kardex.exceptions.NoSuchKardexHttpResponseException;
import co.com.todo.uno.kardex.response.ManagementResponse;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static co.com.todo.uno.kardex.constantes.Errors.NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_POR;
import static co.com.todo.uno.kardex.constantes.Errors.NO_SE_PUDO_COMPLETAR_PROCESO_PORQUE_NO_SE_AGREGO_CORRECTAMENTE_EL_CODIGO_Y_MENSAJE_DE_RESPUESTA;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_800;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_801;
import static co.com.todo.uno.kardex.response.ManagementResponse.KARDEX_803;
import static co.com.todo.uno.kardex.response.ManagementResponse.NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_INTENTE_NUEVAMENTE;

public class HttpResponse {

    private static final Logger LOG = Logger.getLogger(HttpResponse.class);

    public Response buildResponse(KardexHttpResponseDTO kardexHttpResponseDTO) {

        Response.ResponseBuilder responseBuilder;
        try {
            validateKardexHttpResponse(kardexHttpResponseDTO);
            responseBuilder = Response
                .status(kardexHttpResponseDTO.getStatusResponseCode())
                .entity(new KardexResponseDTO(
                            kardexHttpResponseDTO.getCode(), kardexHttpResponseDTO.getMessage()));
        } catch(NoSuchKardexHttpResponseException noSuchKardexHttpResponseException) {
            responseBuilder = Response
                    .status(Response.Status.CONFLICT)
                    .entity(new KardexResponseDTO(
                            KARDEX_803, noSuchKardexHttpResponseException.getMessage()));
        } catch(Exception exception) {
            LOG.error(NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_POR, exception);
            responseBuilder = Response
                .status(Response.Status.CONFLICT)
                .entity(new KardexResponseDTO(
                        KARDEX_800, NO_SE_PUDO_AGREGAR_PRODUCTO_A_INVENTARIO_INTENTE_NUEVAMENTE
                ));
        }
        return responseBuilder
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private void validateKardexHttpResponse(KardexHttpResponseDTO kardexHttpResponseDTO) throws NoSuchKardexHttpResponseException {
        if (kardexHttpResponseDTO == null) {
            throw new NoSuchKardexHttpResponseException(
                    NO_SE_PUDO_COMPLETAR_PROCESO_PORQUE_NO_SE_AGREGO_CORRECTAMENTE_EL_CODIGO_Y_MENSAJE_DE_RESPUESTA);
        }
    }

}
