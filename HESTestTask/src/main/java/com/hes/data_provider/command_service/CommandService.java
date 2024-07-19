package com.hes.data_provider.command_service;

import com.hes.data_provider.DataProviderBase;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.OK;

public class CommandService<T, ID> extends DataProviderBase<T, ID> {
    protected static final ResponseEntity<String> RESPONSE_SUCCESS = new ResponseEntity<>(OK);

    public CommandService(ListCrudRepository<T, ID> listCrudRepository) {
        super(listCrudRepository);
    }

    public ResponseEntity<String> save(T entity) {
        listCrudRepository.save(entity);
        return RESPONSE_SUCCESS;
    }

    public void update(T entity) {
        listCrudRepository.save(entity);
    }
}
