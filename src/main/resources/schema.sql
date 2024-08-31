CREATE TABLE Patient
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    contactInfo VARCHAR(255)
);

CREATE TABLE Appointment
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    reason          VARCHAR(255),
    status          VARCHAR(50),
    patient_id      BIGINT,
    FOREIGN KEY (patient_id) REFERENCES Patient (id)
);