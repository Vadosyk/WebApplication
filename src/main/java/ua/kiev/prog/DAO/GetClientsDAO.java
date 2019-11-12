package ua.kiev.prog.DAO;

import ua.kiev.prog.Entity.EntityClient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Stateless
public class GetClientsDAO extends JpaDAO<EntityClient> implements EntityDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public GetClientsDAO() {
    }

    @Override
    public List<EntityClient> getAllClients() {
        return  entityManager.createQuery("SELECT c FROM EntityClient c", EntityClient.class).getResultList();
    }
}
