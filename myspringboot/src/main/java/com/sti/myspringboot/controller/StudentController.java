package com.sti.myspringboot.controller;


import com.sti.myspringboot.dto.StudentByCourse;
import com.sti.myspringboot.dto.StudentDto;
import com.sti.myspringboot.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student") //  (host)<-/v1/student
public class StudentController {


    private final IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }


    @GetMapping("")
    public List<StudentByCourse> getStudent() {
        return service.getAllStudentWithCourse();
    }
    //PathVariable
    @GetMapping("/{id}")
    public StudentByCourse getStudentById(@PathVariable Long id) {
        return service.getAllStudentWithCourseById(id);
    }

    //QueryParameter
    @GetMapping("/")
    public StudentByCourse getStudentByIdQuery(@RequestParam Long accountNumber) {
        return service.getAllStudentWithCourseByAccountNumber(accountNumber);
    }


    @PostMapping()
    public void saveStudent(@Valid @RequestBody StudentDto dto) {
        service.save(dto);
    }

    /*
    @GetMapping ->  get info
    @PostMapping -> add info
    @PutMapping -> update info  { id:"", name:"", status:"", address: "" ....  }
    @DeleteMapping -> delete info
    @PatchMapping -> partial update info  { id:"", status:""},  { id:"", name:""}
    */
}
