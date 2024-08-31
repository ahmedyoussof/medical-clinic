package medical.clinic.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String name;
    private String contactInfo;
}