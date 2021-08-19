package com.LPAProgram.patientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;
    private String firstName;
    private String lastName;
    private String address;
    private Integer nic;
    private Date regDate;
    private Long userId;
    private Long departmentId;

}
