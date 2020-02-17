package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.dto.ProductRequestDTO;
import co.com.todo.uno.kardex.entity.Product;
import co.com.todo.uno.kardex.repository.IProductRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
public class ProductServices {

    @Inject
    private IProductRepository iProductRepository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addProduct(ProductRequestDTO productRequestDTO) {
        Product product = buildProduct(productRequestDTO);
        iProductRepository.save(product);
    }

    private Product buildProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setMinimumAmount(productRequestDTO.getMinimumAmount());
        product.setMaximumAmount(productRequestDTO.getMaximumAmount());
        product.setUnitValue(productRequestDTO.getUnitValue());
        product.setProductName(productRequestDTO.getProductName());
        return product;
    }

    public boolean productExists(Long productId) {
        return productId == null ? false : iProductRepository.exists(productId);
    }
}
