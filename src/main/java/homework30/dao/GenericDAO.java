package homework30.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    void save(T entity);
    T findById(ID id);
    T findByField(String stringField);
    List<T> findAll();
    T update(T entity);
    boolean deleteById(ID id);

}

