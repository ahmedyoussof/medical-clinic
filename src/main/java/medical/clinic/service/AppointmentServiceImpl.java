package medical.clinic.service;

import lombok.RequiredArgsConstructor;
import medical.clinic.exceptions.ResourceNotFoundException;
import medical.clinic.model.Appointment;
import medical.clinic.model.Patient;
import medical.clinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;

    @Override
    public List<Appointment> getTodayAppointments() {
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);
        return appointmentRepository.findTodayAppointments(startOfDay, endOfDay);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        Patient patient = patientService.findById(appointment.getPatient().getId());
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atTime(LocalTime.MIN);
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return appointmentRepository.findAppointmentsByDate(startOfDay, endOfDay);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientName(String patientName) {
        return appointmentRepository.findAppointmentsByPatientName(patientName);
    }

    @Override
    public Appointment cancelAppointment(Long appointmentId, String reason) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
        appointment.setStatus("Cancelled");
        appointment.setCancelReason(reason);
        return appointmentRepository.save(appointment);
    }
}