package com.sti.myspringboot.controller;


import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/student") //  (host)<-/v1/student
public class StudentController {

    public StudentController() {
    }

    @GetMapping("")
    public List<String> getAll() {




        List<String> list = Arrays.asList("Luis", "Pedro", "Carlos", "Daniel", "Andrey", "Marlon", "Cesar");
        return list;
    }

    /*
    @GetMapping ->  get info
    @PostMapping -> add info
    @PutMapping -> update info  { id:"", name:"", status:"", address: "" ....  }
    @DeleteMapping -> delete info
    @PatchMapping -> partial update info  { id:"", status:""},  { id:"", name:""}
    */
}
