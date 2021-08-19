package com.LPAProgram.patientservice.service;


import com.LPAProgram.patientservice.VO.Department;
import com.LPAProgram.patientservice.VO.ResponseTemplateVO;
import com.LPAProgram.patientservice.VO.User;
import com.LPAProgram.patientservice.VO.test;
import com.LPAProgram.patientservice.entity.Patient;
import com.LPAProgram.patientservice.repository.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Patient savePatient(Patient patient) {
        log.info("Inside saveUser of UserService");
        return patientRepository.save(patient);
    }


    public ResponseTemplateVO getPatientWithUser(Long patientId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        log.info("Inside getPatientWithUser of PatientService");
        Patient patient = patientRepository.findByPatientId(patientId);
        System.out.print("user id  ----"+patient.getUserId());

        User user = restTemplate.getForObject("http://USER-SERVICE/users/" + patient.getUserId(),User.class);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + patient.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setPatient(patient);
        vo.setDepartment(department);

        return  vo;
    }


}
