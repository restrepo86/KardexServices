package co.com.todo.uno.kardex.repository;

import co.com.todo.uno.kardex.entity.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEntryRepository extends CrudRepository<Entry, Long> {

    List<Entry> findByProductId(Long productId);

}
