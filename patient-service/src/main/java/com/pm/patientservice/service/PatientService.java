package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient -> PatientMapper.patientToPatientResponseDTO(patient)).toList();
        return patientResponseDTOs;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists"+patientRequestDTO.getEmail());
        }
       Patient newpatient = patientRepository.save(PatientMapper.patientRequestDTOToPatient(patientRequestDTO));

       return PatientMapper.patientToPatientResponseDTO(newpatient);

    }

    public PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient not found with Id: "+id));

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)) {
            throw new EmailAlreadyExistsException("Email already exists"+patientRequestDTO.getEmail());
        }

        patient.setFirstName(patientRequestDTO.getFirstName());
        patient.setLastName(patientRequestDTO.getLastName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setGender(patientRequestDTO.getGender());
        patient.setAge(Integer.parseInt(patientRequestDTO.getAge()));
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getBirthDate()));
        patient.setEmail(patientRequestDTO.getEmail());

        Patient updatedpatient = patientRepository.save(patient);
        return PatientMapper.patientToPatientResponseDTO(updatedpatient);


    }

    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}
