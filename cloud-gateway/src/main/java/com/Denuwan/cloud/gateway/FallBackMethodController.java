package com.Denuwan.cloud.gateway;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FallBackMethodController {
    @CrossOrigin
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }
    @CrossOrigin
    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }
    @CrossOrigin
    @GetMapping("/patientServiceFallBack")
    public String patientServiceFallBackMethod() {
        return "Patient Service is taking longer than Expected." +
                " Please try again later";
    }
    @CrossOrigin
    @GetMapping("/stockServiceFallBack")
    public String stockServiceFallBackMethod() {
        return "Stock Service is taking longer than Expected." +
                " Please try again later";
    }
}
