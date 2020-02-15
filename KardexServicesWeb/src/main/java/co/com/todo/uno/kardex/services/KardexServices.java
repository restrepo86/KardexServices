package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.domain.services.KardexDomainServices;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/kardex")
public class KardexServices {

    @Inject
    private KardexDomainServices kardexDomainServices;

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(ProductRequestDTO productRequestDTO) throws EmptyPropertiesException {
        kardexDomainServices.addProduct(productRequestDTO);
    }

}