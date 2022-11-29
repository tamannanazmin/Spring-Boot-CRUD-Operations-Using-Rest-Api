package com.example.learning.SpringBootCrud.controller;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.service.SubjectService;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<SubjectDto> getAllSubject() { //TODO RETURN HOBE API RESPONSE
        return subjectService.getAllSubjects();
    }

    /*@PostMapping("/subjects")
    public ResponseEntity<SubjectDto> createUser(@Valid @RequestBody SubjectDto subjectDto){

        // convert UserDto to User entity
        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setEmail(subjectDto.getEmail());
        Subject savedSubject = subjectService.createUser(subject);

        // convert User entity to UserDto class
        SubjectDto subjectResponse = new SubjectDto();
        subjectResponse.setId(savedSubject.getId());
        subjectResponse.setName(savedSubject.getName());
        subjectResponse.setEmail(savedSubject.getEmail());
        // don't provide password to client
        // userResponse.setPassword(savedUser.getPassword());

        return new ResponseEntity<SubjectDto>(subjectResponse, HttpStatus.CREATED);
    }*/
    @PostMapping("/subjects")
    public ApiResponse addSubject(@Valid @RequestBody SubjectDto subjectDto) {
        /*if(subjectService.exist(subjectDto.getEmail())== true){
            return subjectService.addSubject(subjectDto.setEmail("Email exist"));
        }else {
            return subjectService.addSubject(subjectDto);
        }*/
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

//    @RequestMapping("/subjects/{id}")
//    public Subject getSearchedSubject(@PathVariable String id){
//        return subjectService.getSearchedSubject(id);
//
//    }

}
