package com.sti.myspringboot.services;

import com.sti.myspringboot.dto.CourseDto;
import com.sti.myspringboot.dto.StudentByCourse;
import com.sti.myspringboot.dto.StudentDto;
import com.sti.myspringboot.entities.CourseRating;
import com.sti.myspringboot.entities.Student;
import com.sti.myspringboot.repositories.IStudentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService{
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentByCourse> getAllStudentWithCourse() {
       logger.info("getting student info with courses >>");

       return studentRepository.findAll().stream().map(x->{
            StudentByCourse dto = new StudentByCourse();
            dto.setId(x.getId());
            dto.setAccountNumber(x.getAccountNumber());
            dto.setDayOfBirth(x.getDayOfBirth());
            dto.setYearOfEnrollment(x.getYearOfEnrollment());
            dto.setFullName(String.format("%s %s", x.getFistName(), x.getLastName()));
            // set courses
            dto.setCourse(getCourses(x.getRatings()));

            return dto;
        }).toList();

    }

    @Override
    public StudentByCourse getAllStudentWithCourseById(Long id) {
        String currentUser = getCurrentUser();
        logger.info("the current user is {}", currentUser);
        logger.info("looking for student with id {}", id);
        //validate if exit
        Student student = studentRepository.findById(id)
                                            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            String.format("user with id %s not found", id))
                                            );

        StudentByCourse dto = new StudentByCourse();
        dto.setId(student.getId());
        dto.setAccountNumber(student.getAccountNumber());
        dto.setDayOfBirth(student.getDayOfBirth());
        dto.setYearOfEnrollment(student.getYearOfEnrollment());
        dto.setFullName(String.format("%s %s", student.getFistName(), student.getLastName()));
        // set courses
        dto.setCourse(getCourses(student.getRatings()));
        return dto;
    }

    @Override
    public StudentByCourse getAllStudentWithCourseByAccountNumber(Long accountNumber) {
        logger.info("looking student with accountNumber {}", accountNumber);
        Student entity = studentRepository.findByAccountNumber(accountNumber);
        if(entity == null){
            logger.warn("student not found >>>>>");
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("user with account number %s not found", accountNumber));
        }

        StudentByCourse dto = new StudentByCourse();
        dto.setId(entity.getId());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setDayOfBirth(entity.getDayOfBirth());
        dto.setYearOfEnrollment(entity.getYearOfEnrollment());
        dto.setFullName(String.format("%s %s", entity.getFistName(), entity.getLastName()));
        // set courses
        dto.setCourse(getCourses(entity.getRatings()));
        return dto;
    }

    @Override
    public List<StudentDto> getStudent() {
        return List.of();
    }

    @Override
    public void save(StudentDto studentDto) {
        Student entity = new Student(studentDto.getName(), studentDto.getLastName(), studentDto.getYearOfEnrollment(), studentDto.getDayOfBirth(), studentDto.getAccountNumber());
        studentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {

    }

    private List<CourseDto> getCourses(List<CourseRating> ratings) {
        return ratings.stream().map(r -> {
            CourseDto dto = new CourseDto();
            dto.setId(r.getCourse().getId());
            dto.setName(r.getCourse().getName());
            dto.setCapacity(r.getCourse().getCapacity());
            dto.setTime(r.getCourse().getTime());
            dto.setRating(r.getRating());
            return dto;
        }).toList();
    }

    private String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  authentication.getPrincipal().toString();
    }

}
