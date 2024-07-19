package com.hes.data_provider.query_service;

import com.hes.data_provider.DataProviderBase;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public abstract class QueryService<T, ID> extends DataProviderBase<T, ID> {

    public QueryService(ListCrudRepository<T, ID> listCrudRepository) {
        super(listCrudRepository);
    }

    public List<T> findAll() {
        return listCrudRepository.findAll();
    }

    public T findById(ID id) {
        return listCrudRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
