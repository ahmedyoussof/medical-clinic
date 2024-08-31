INSERT INTO Patient (name, contactInfo) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO Patient (name, contactInfo) VALUES ('Jane Smith', 'jane.smith@example.com');

INSERT INTO Appointment (date, reason, status, patient_id) VALUES ('2024-08-31 10:00:00', 'Routine Checkup', 'Scheduled', 1);
INSERT INTO Appointment (date, reason, status, patient_id) VALUES ('2024-08-31 11:00:00', 'Follow-up', 'Scheduled', 2);