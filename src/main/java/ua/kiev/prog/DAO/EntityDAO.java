package ua.kiev.prog.DAO;

import ua.kiev.prog.Entity.EntityClient;

import java.util.List;

public interface EntityDAO extends DAO<EntityClient> {
     List<EntityClient> getAllClients();
}
