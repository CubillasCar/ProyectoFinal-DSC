package com.hospital.repository;


import com.hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPacienteRepo  extends JpaRepository<Paciente, Integer> {


}
