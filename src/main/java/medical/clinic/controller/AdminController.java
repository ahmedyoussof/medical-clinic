package medical.clinic.controller;

import lombok.RequiredArgsConstructor;
import medical.clinic.dto.AppointmentDTO;
import medical.clinic.model.Appointment;
import medical.clinic.service.AppointmentService;
import medical.clinic.utils.AppointMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/appointments/filter/date/{date}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDate(date);

        List<AppointmentDTO> appointmentDTOs = appointments.stream().map(AppointMapper::mapToAppointmentDTO).toList();

        return ResponseEntity.ok(appointmentDTOs);
    }

    @GetMapping("/appointments/filter/name/{patientName}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatientName(@PathVariable String patientName) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientName(patientName);

        List<AppointmentDTO> appointmentDTOs = appointments.stream().map(AppointMapper::mapToAppointmentDTO).toList();

        return ResponseEntity.ok(appointmentDTOs);
    }

    // want to cancel appointment with reason
    @PutMapping("/appointments/cancel/{appointmentId}")
    public ResponseEntity<AppointmentDTO> cancelAppointment(@PathVariable Long appointmentId, @RequestParam String reason) {
        Appointment appointment = appointmentService.cancelAppointment(appointmentId, reason);

        AppointmentDTO appointmentDTO = AppointMapper.mapToAppointmentDTO(appointment);

        return ResponseEntity.ok(appointmentDTO);
    }

    @GetMapping("/appointments/patient/{patientId}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);

        List<AppointmentDTO> appointmentDTOs = appointments.stream().map(AppointMapper::mapToAppointmentDTO).toList();

        return ResponseEntity.ok(appointmentDTOs);
    }
}
