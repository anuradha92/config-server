package com.LPAProgram.patientservice.controller;

import com.LPAProgram.patientservice.VO.ResponseTemplateVO;
import com.LPAProgram.patientservice.entity.Patient;
import com.LPAProgram.patientservice.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patienStervice;

    @PostMapping("/")
    public Patient savePatient(@RequestBody Patient patient) {
        log.info("Inside savePatient of PatientController");
        return patienStervice.savePatient(patient);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getPatientWithUser(@PathVariable("id") Long patientId) {
        log.info("Inside getPatientWithUser of PatientController");
        return patienStervice.getPatientWithUser(patientId);
    }


}
