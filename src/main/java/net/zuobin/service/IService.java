package net.zuobin.service;

import java.io.Serializable;

/**
 * @author Sahinn
 * @date 16/6/17
 */
public interface IService<T extends Serializable> {

    T save(T t);

    void delete(T t);

    T update(T t);

    T findById(String id);
}
