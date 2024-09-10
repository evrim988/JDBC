package org.example._02_JDBC_Forum.repositories;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {

    void save(T t);
    void delete(int id);
    void update(T t);
    List<T> findAll();
    Optional<T> findById(int id);

}
