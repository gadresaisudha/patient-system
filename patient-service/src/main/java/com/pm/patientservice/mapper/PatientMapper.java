package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO patientToPatientResponseDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setFirstName(patient.getFirstName());
        patientResponseDTO.setLastName(patient.getLastName());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setGender(patient.getGender());
        patientResponseDTO.setAge(String.valueOf(patient.getAge()));
        patientResponseDTO.setBirthDate(patient.getBirthDate().toString());
        return patientResponseDTO;
    }

    public static Patient patientRequestDTOToPatient(PatientRequestDTO patientRequestDTO) {

        Patient newPatient = new Patient();
        newPatient.setFirstName(patientRequestDTO.getFirstName());
        newPatient.setLastName(patientRequestDTO.getLastName());
        newPatient.setAddress(patientRequestDTO.getAddress());
        newPatient.setEmail(patientRequestDTO.getEmail());
        newPatient.setGender(patientRequestDTO.getGender());
        newPatient.setAge(Integer.parseInt(patientRequestDTO.getAge()));
        newPatient.setBirthDate(LocalDate.parse(patientRequestDTO.getBirthDate()));
        newPatient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return newPatient;

    }
}
