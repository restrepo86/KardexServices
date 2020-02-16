package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.domain.services.KardexDomainServices;
import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.dto.KardexHttpResponseDTO;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;
import co.com.todo.uno.kardex.mapper.response.HttpResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kardex")
public class KardexServices {

    @Inject
    private KardexDomainServices kardexDomainServices;

    @Inject
    private HttpResponse httpResponse;

    @Path("/producto")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(ProductRequestDTO productRequestDTO) {
        KardexHttpResponseDTO kardexHttpResponseDTO = kardexDomainServices.addProduct(productRequestDTO);
        return httpResponse.buildResponse(kardexHttpResponseDTO);
    }

    @Path("/entrada")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerEntry(EntryRequestDTO entryRequestDTO) {
        KardexHttpResponseDTO kardexHttpResponseDTO = kardexDomainServices.registerEntry(entryRequestDTO);
        return httpResponse.buildResponse(kardexHttpResponseDTO);
    }

    @Path("/salida")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerOutput(RegisterOutputRequestDTO registerOutputRequestDTO) {
        KardexHttpResponseDTO kardexHttpResponseDTO = kardexDomainServices.registerOutput(registerOutputRequestDTO);
        return httpResponse.buildResponse(kardexHttpResponseDTO);
    }

}