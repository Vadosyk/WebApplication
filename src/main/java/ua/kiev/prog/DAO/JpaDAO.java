package ua.kiev.prog.DAO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

@Stateless
public class JpaDAO<T> implements DAO<T> {


    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityType;

    public JpaDAO() {
        this.entityType = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public T getByID(Long ID) {
        return entityManager.find(entityType, ID);
    }


    @Override
    public T update(T type) {
        return entityManager.merge(type);
    }

    @Override
    public void delete(T type) {
        entityManager.remove(entityManager.contains(type) ? type : entityManager.merge(type));
    }

}