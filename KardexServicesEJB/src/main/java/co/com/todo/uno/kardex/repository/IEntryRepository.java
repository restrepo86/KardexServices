package co.com.todo.uno.kardex.repository;

import co.com.todo.uno.kardex.entity.Entry;
import org.springframework.data.repository.CrudRepository;

public interface IEntryRepository extends CrudRepository<Entry, Long> {
}
