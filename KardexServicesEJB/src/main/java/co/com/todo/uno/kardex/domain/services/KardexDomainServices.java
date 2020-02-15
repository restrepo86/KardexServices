package co.com.todo.uno.kardex.domain.services;

import co.com.todo.uno.kardex.exceptions.EmptyPropertiesException;
import co.com.todo.uno.kardex.mapper.DomainMapper;
import co.com.todo.uno.kardex.domain.validation.add.product.KardexAddProductValidations;
import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.services.ProductServices;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
public class KardexDomainServices {

    @Inject
    private KardexAddProductValidations kardexAddProductValidations;

    @Inject
    private ProductServices productServices;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addProduct(ProductRequestDTO productRequestDTO) throws EmptyPropertiesException {
        kardexAddProductValidations.execute(DomainMapper.buildProductValidationsDTO(productRequestDTO));
        productServices.addProduct(productRequestDTO);
    }

}
