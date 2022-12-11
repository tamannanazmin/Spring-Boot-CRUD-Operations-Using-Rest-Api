package com.example.learning.SpringBootCrud.controller;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.service.SubjectService;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public ApiResponse getAllSubject() { //TODO RETURN HOBE API RESPONSE

        return subjectService.getAllSubjects();
    }

    @PostMapping("/subjects")
    public ApiResponse addSubject(@Valid @RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }

    @PutMapping("/subjects/{id}")
    public ApiResponse updateSubject(@PathVariable String id, @RequestBody SubjectDto subjectDto) {
        return subjectService.updateSubject(id, subjectDto);
    }

    @DeleteMapping("/subjects/{id}")
    public ApiResponse deleteSubject(@PathVariable String id) {
        return subjectService.deleteSubject(id);
    }

}
