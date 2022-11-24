package com.example.learning.SpringBootCrud.controller;
import com.example.learning.SpringBootCrud.service.SubjectService;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//URL and data collection are handled her
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/subjects")
    public ApiResponse addSubject(@RequestBody Subject subject ){
        return subjectService.addSubject(subject);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/subjects/{id}")
    public ApiResponse updateSubject(@PathVariable String id, @RequestBody Subject subject ){
        return subjectService.updateSubject(id, subject);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/subjects/{id}")
    public ApiResponse deleteSubject(@PathVariable String id){
        return subjectService.deleteSubject(id);
    }

    @RequestMapping("/subjects/{id}")
    public Subject getSearchedSubject(@PathVariable String id){
        return subjectService.getSearchedSubject(id);

    }

}
