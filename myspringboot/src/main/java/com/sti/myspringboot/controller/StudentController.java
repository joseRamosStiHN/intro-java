package com.sti.myspringboot.controller;


import com.sti.myspringboot.dto.StudentByCourse;
import com.sti.myspringboot.entities.Course;
import com.sti.myspringboot.entities.CourseRating;
import com.sti.myspringboot.entities.CourseRatingKey;
import com.sti.myspringboot.entities.Student;
import com.sti.myspringboot.repositories.ICourseRatingRepository;
import com.sti.myspringboot.repositories.ICourseRepository;
import com.sti.myspringboot.repositories.IStudentRepository;
import com.sti.myspringboot.services.IStudentService;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/student") //  (host)<-/v1/student
public class StudentController {



//    private final ICourseRepository courseRepository;
//    private final IStudentRepository studentRepository;
//    private final ICourseRatingRepository ratingRepository;

//    public StudentController(ICourseRepository courseRepository, IStudentRepository studentRepository, ICourseRatingRepository ratingRepository) {
//        this.courseRepository = courseRepository;
//        this.studentRepository = studentRepository;
//        this.ratingRepository = ratingRepository;
//    }

    private final IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }


    @GetMapping("")
    public List<StudentByCourse> getStudent() {
        return service.getAllStudentWithCourse();

    }

//    @GetMapping("")
//    public CourseRating getAll() {
//        Student studentEntity = new Student( "Jose", "Ramos", "2007", LocalDate.now().plusYears(-12), 2000725454L);
//        Course courseEntity = new Course("Math", LocalTime.now(),30);
//
//        studentRepository.save(studentEntity);
//        courseRepository.save(courseEntity);
//
//        // insertar la relación
//        CourseRatingKey courseRatingKey = new CourseRatingKey();
//        courseRatingKey.setStudentId(studentEntity.getId());
//        courseRatingKey.setCourseId(courseEntity.getId());
//
//        CourseRating courseRatingEntity = new CourseRating();
//        courseRatingEntity.setId(courseRatingKey);
//        courseRatingEntity.setStudent(studentEntity);
//        courseRatingEntity.setCourse(courseEntity);
//        courseRatingEntity.setRating(100L);
//        ratingRepository.save(courseRatingEntity);
//
//
//
//
//        List<String> list = Arrays.asList("Luis", "Pedro", "Carlos", "Daniel", "Andrey", "Marlon", "Cesar");
//        return courseRatingEntity;
//    }

    /*
    @GetMapping ->  get info
    @PostMapping -> add info
    @PutMapping -> update info  { id:"", name:"", status:"", address: "" ....  }
    @DeleteMapping -> delete info
    @PatchMapping -> partial update info  { id:"", status:""},  { id:"", name:""}
    */
}
