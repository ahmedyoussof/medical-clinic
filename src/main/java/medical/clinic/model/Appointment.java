package medical.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime appointmentDate;
    private String reason;
    private String status; //"Scheduled", "Cancelled", "Completed"

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}