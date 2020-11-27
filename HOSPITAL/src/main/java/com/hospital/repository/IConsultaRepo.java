package com.hospital.repository;

import com.hospital.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IConsultaRepo extends JpaRepository<Consulta, Integer>, IGenericRepo<Consulta, Integer> {
}
