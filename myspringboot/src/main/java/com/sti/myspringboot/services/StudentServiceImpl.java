package com.sti.myspringboot.services;

import com.sti.myspringboot.dto.StudentByCourse;
import com.sti.myspringboot.dto.StudentDto;
import com.sti.myspringboot.repositories.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentByCourse> getAllStudentWithCourse() {
       return studentRepository.findAll().stream().map(x->{
            StudentByCourse dto = new StudentByCourse();
            dto.setId(x.getId());
            dto.setAccountNumber(x.getAccountNumber());
            dto.setDayOfBirth(x.getDayOfBirth());
            dto.setFullName(String.format("%s %s", x.getFistName(), x.getLastName()));

            return dto;
        }).toList();

    }

    @Override
    public List<StudentDto> getStudent() {
        return List.of();
    }

    @Override
    public void save(StudentDto studentDto) {

    }

    @Override
    public void delete(Long id) {

    }


}
