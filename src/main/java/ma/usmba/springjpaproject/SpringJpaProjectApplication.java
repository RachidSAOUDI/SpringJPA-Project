package ma.usmba.springjpaproject;

import ma.usmba.springjpaproject.entities.Patient;
import ma.usmba.springjpaproject.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringJpaProjectApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Hamid", new Date(), false, 56));
        patientRepository.save(new Patient(null, "Nabil", new Date(), true, 76));
        patientRepository.save(new Patient(null, "Jamal", new Date(), false, 99));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println("=====================================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
        });
        System.out.println("**************************");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient!=null) {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(670);
        patientRepository.save(patient);
        patientRepository.deleteById(1L);
    }
}
