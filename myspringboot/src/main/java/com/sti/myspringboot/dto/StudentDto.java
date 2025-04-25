package com.sti.myspringboot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {
    private Long id;
    @NotNull(message = "")
    private String name;
    @NotNull(message = "campo es obligatorio")
    private String lastName;
    private String fullName;
    @Pattern(regexp = "", message = "")
    private String yearOfEnrollment;
    private LocalDate dayOfBirth;
    private Long accountNumber;

}
