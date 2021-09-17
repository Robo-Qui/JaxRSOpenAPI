package fr.istic.taa.jaxrs.dao;

import java.io.Serializable;

public interface IGenericManager<T, PK extends Serializable> {
    T save(T t);
    T read(PK id);
    T update(T t);
    void delete(T t);
}

