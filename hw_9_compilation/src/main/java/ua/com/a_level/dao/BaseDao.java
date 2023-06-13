package ua.com.a_level.dao;

import ua.com.a_level.entity.BaseEntity;

import java.util.Collection;

public interface BaseDao<E extends BaseEntity> {
    void create(E e);

    void update(E e);

    void delete(Long id);

    E findById(Long id);

    Collection<E> findAll();
}
