package com.hospital.service.core.impl;

import com.hospital.model.Consulta;
import com.hospital.repository.IConsultaRepo;
import com.hospital.repository.IGenericRepo;
import com.hospital.service.core.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService {


	@Autowired
	private IConsultaRepo repo;

	@Autowired
	protected IGenericRepo<Consulta, Integer> getRepo(){
		return repo;
	}


}
