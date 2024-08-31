package medical.clinic.service;

import medical.clinic.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getTodayAppointments();

    List<Appointment> getAppointmentsByPatientId(Long patientId);

    Appointment saveAppointment(Appointment appointment);
}
