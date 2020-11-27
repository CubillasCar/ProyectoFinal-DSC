package com.hospital.repository;

import com.hospital.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoRepo extends JpaRepository<Medico, Integer>, IGenericRepo<Medico, Integer> {
}
