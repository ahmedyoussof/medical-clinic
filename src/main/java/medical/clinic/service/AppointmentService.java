package medical.clinic.service;

import medical.clinic.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getTodayAppointments();

    List<Appointment> getAppointmentsByPatientId(Long patientId);

    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAppointmentsByDate(LocalDate date);

    List<Appointment> getAppointmentsByPatientName(String patientName);

    Appointment cancelAppointment(Long appointmentId, String reason);
}
