package com.example.learning.SpringBootCrud.controller;
import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.service.SubjectService;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//URL and data collection are handled her
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

 //   @RequestMapping("/subjects")
//    public List<Subject> getAllSubjects(){
//        return subjectService.getAllSubjects();
//    }

    @GetMapping("/subjects")
    public List<SubjectDto> getAllSubject(){
        return subjectService.getAllSubjects();
    }
    @PostMapping("/subjects")
    public ApiResponse addSubject(@RequestBody SubjectDto subjectDto ){
        return subjectService.addSubject(subjectDto);
    }
    @PutMapping("/subjects/{id}")
    public ApiResponse updateSubject(@PathVariable String id, @RequestBody SubjectDto subjectDto ){
        return subjectService.updateSubject(id, subjectDto);
    }

    @DeleteMapping("/subjects/{id}")
    public ApiResponse deleteSubject(@PathVariable String id){
        return subjectService.deleteSubject(id);
    }

//    @RequestMapping("/subjects/{id}")
//    public Subject getSearchedSubject(@PathVariable String id){
//        return subjectService.getSearchedSubject(id);
//
//    }

}
