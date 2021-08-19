package com.LPAProgram.patientservice.VO;

import com.LPAProgram.patientservice.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Patient patient;
    private User user;
    private Department department;

}
