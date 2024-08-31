package medical.clinic.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Data Transfer Object for Appointment")
public class AppointmentDTO {

    @Schema(hidden = true)
    private Long id;

    @Schema(example = "2023-10-01T10:00:00")
    private LocalDateTime date;

    @Schema(example = "General Checkup")
    private String reason;

    @Schema(example = "Scheduled")
    private String status;

    @NotNull
    @Schema(example = "123")
    private Long patientId;
}
