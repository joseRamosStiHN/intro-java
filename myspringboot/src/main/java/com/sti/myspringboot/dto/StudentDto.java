package com.sti.myspringboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String fullName;
    private String yearOfEnrollment;
    private LocalDate dayOfBirth;
    private Long accountNumber;

}
