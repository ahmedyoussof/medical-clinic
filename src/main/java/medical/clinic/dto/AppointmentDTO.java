package medical.clinic.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private LocalDateTime appointmentDate;
    private String reason;
    private String status;
    private Long patientId;
}
