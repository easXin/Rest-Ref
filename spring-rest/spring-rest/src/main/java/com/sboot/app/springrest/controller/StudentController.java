package com.sboot.app.springrest.controller;

import com.sboot.app.springrest.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// client uses these endpoints to access restAPI
@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Ramesh","Belly");
    }
    // how does spring app takes java object convert to
    // json, and use http methods return object back to client

    // messageConvertor    MappingJackson2HttpMessageConverter

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> stus = new ArrayList<>();
        stus.add(new Student("David","Nancy"));
        stus.add(new Student("Joseph","Miller"));
        stus.add(new Student("Henry","Junior"));
        stus.add(new Student("Johanna","Alexander"));
        stus.add(new Student("George","Jim"));
        return stus;
    }

    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVar(@PathVariable(name = "firstName") String fName,
                                  @PathVariable(name = "lastName") String lName){
        return new Student(fName,lName);
    }

    // hand query parameter  [ student ? fName = Ramesh]
    // http://localhost:8080/student/query?firstName=Eric&lastName=Wang
    @GetMapping("/student/query")
    public Student studentQueryParam(@RequestParam(name= "firstName") String fName,
                                     @RequestParam(name= "lastName")String lName){
        return new Student(fName,lName);
    }
}

