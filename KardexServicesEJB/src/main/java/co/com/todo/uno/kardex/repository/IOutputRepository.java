package co.com.todo.uno.kardex.repository;

import co.com.todo.uno.kardex.entity.Output;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOutputRepository extends CrudRepository<Output, Long> {

    List<Output> findByProductId(Long productId);

}
