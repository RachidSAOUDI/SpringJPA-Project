package ma.usmba.springjpaproject.repositories;

import ma.usmba.springjpaproject.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
