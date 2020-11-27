package com.hospital.service.core.impl;


import com.hospital.model.Medico;
import com.hospital.repository.IGenericRepo;
import com.hospital.repository.IMedicoRepo;
import com.hospital.service.core.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService {


    @Autowired
    private IMedicoRepo repo;

    @Autowired
    protected IGenericRepo<Medico, Integer> getRepo(){
        return repo;
    }


}
