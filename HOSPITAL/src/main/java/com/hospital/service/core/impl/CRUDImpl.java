package com.hospital.service.core.impl;




import com.hospital.repository.IGenericRepo;
import com.hospital.service.core.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T createOrUpdate(T obj) {
        return getRepo().save(obj);
    }


    @Override
    public List<T> findAll(){
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id){
       return getRepo().findById(id).orElse(null);
    }

    @Override
    public void deleteById(ID id){
        getRepo().deleteById(id);
    }

}
