package com.hes.data_provider;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.ListCrudRepository;

@RequiredArgsConstructor
public class DataProviderBase<T, ID> {
    protected final ListCrudRepository<T, ID> listCrudRepository;
}
