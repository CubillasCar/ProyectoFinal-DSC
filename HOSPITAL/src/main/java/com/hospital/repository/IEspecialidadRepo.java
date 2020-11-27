package com.hospital.repository;

import com.hospital.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadRepo extends JpaRepository<Especialidad, Integer>, IGenericRepo<Especialidad, Integer> {
}
