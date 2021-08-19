package com.LPAProgram.patientservice.repository;

import com.LPAProgram.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByPatientId(Long patientId);
}
