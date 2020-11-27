package com.hospital.service.core.impl;


import com.hospital.model.Especialidad;
import com.hospital.repository.IEspecialidadRepo;
import com.hospital.repository.IGenericRepo;
import com.hospital.service.core.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService {


    @Autowired
    private IEspecialidadRepo repo;

    @Autowired
    protected IGenericRepo<Especialidad, Integer> getRepo(){
        return repo;
    }


}
