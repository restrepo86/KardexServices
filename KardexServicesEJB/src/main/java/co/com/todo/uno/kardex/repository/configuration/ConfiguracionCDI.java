package co.com.todo.uno.kardex.repository.configuration;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ConfiguracionCDI {

    @Produces
    @PersistenceContext
    public EntityManager entityManager;
    
}
