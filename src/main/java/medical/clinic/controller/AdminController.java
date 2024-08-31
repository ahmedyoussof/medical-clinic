package medical.clinic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import medical.clinic.dto.AppointmentDTO;
import medical.clinic.model.Appointment;
import medical.clinic.service.AppointmentService;
import medical.clinic.utils.AppointMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AppointmentService appointmentService;


    @GetMapping("/appointments/today")
    public ResponseEntity<List<AppointmentDTO>> getTodayAppointments() {
        List<Appointment> appointments = appointmentService.getTodayAppointments();

        List<AppointmentDTO> appointmentDTOs = appointments.stream().map(AppointMapper::mapToAppointmentDTO).toList();

        return ResponseEntity.ok(appointmentDTOs);
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentDTO> addNewAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = AppointMapper.mapToAppointment(appointmentDTO);

        Appointment savedAppointment = appointmentService.saveAppointment(appointment);

        AppointmentDTO savedAppointmentDTO = AppointMapper.mapToAppointmentDTO(savedAppointment);

        return ResponseEntity.ok(savedAppointmentDTO);
    }

    @GetMapping("/appointments/patient/{patientId}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);

        List<AppointmentDTO> appointmentDTOs = appointments.stream().map(AppointMapper::mapToAppointmentDTO).toList();

        return ResponseEntity.ok(appointmentDTOs);
    }
}
