package medical.clinic.config;

import medical.clinic.model.Patient;
import medical.clinic.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public DataInitializer(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) {
        if (patientRepository.count() == 0) {
            Patient patient1 = Patient.builder()
                    .name("John Doe")
                    .build();
            Patient patient2 = Patient.builder()
                    .name("Jake Doe")
                    .build();

            patientRepository.save(patient1);
            patientRepository.save(patient2);

            System.out.println("Sample data has been initialized.");
        } else {
            System.out.println("Data already exists, skipping initialization.");
        }
    }
}
