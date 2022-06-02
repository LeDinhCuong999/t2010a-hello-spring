package com.aptech.t2010a.hellospring.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder

public class Student {
    private String rollNumber;
    private String fullName;
    private String phone;
    private String address;
    private LocalDateTime dob;
}
