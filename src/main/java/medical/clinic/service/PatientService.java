package medical.clinic.service;

import medical.clinic.model.Patient;

public interface PatientService {

    Patient findById(Long id);
}
