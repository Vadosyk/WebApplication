package ua.kiev.prog.DAO;


public interface DAO<T> {
    T getByID(Long ID);
    T update(T type);
    void delete(T type);
}
