package medical.clinic.utils;

import medical.clinic.dto.AppointmentDTO;
import medical.clinic.model.Appointment;
import medical.clinic.model.Patient;

public class AppointMapper {
    public static Appointment mapToAppointment(medical.clinic.dto.AppointmentDTO appointmentDTO) {
        return Appointment.builder()
                .id(appointmentDTO.getId())
                .date(appointmentDTO.getDate())
                .reason(appointmentDTO.getReason())
                .status(appointmentDTO.getStatus())
                .patient(Patient.builder()
                        .id(appointmentDTO.getPatientId())
                        .build())
                .build();
    }

    public static AppointmentDTO mapToAppointmentDTO(Appointment appointment) {
        return AppointmentDTO.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .reason(appointment.getReason())
                .status(appointment.getStatus())
                .patientId(appointment.getPatient().getId())
                .build();
    }
}
