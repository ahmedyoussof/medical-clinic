package medical.clinic.service;

import lombok.RequiredArgsConstructor;
import medical.clinic.exceptions.ResourceNotFoundException;
import medical.clinic.model.Patient;
import medical.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient not found please create patient first!"));
    }
}
