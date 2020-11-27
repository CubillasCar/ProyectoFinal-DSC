package com.hospital.service.core;

import java.util.List;

public interface ICRUD<T, ID> {

    T createOrUpdate (T pac);
    List<T> findAll();
    T findById(ID id);
    void deleteById(ID id);
}
