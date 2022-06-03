package com.aptech.t2010a.hellospring.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")

public class Student {
    @Id
    private String rollNumber;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String note;
    private LocalDateTime dob;
    private int status;
}
