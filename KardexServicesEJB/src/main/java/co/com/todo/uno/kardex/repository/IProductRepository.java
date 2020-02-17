package co.com.todo.uno.kardex.repository;

import co.com.todo.uno.kardex.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
}
