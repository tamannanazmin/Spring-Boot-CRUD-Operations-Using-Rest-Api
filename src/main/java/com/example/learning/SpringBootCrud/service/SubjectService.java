package com.example.learning.SpringBootCrud.service;

import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import com.example.learning.SpringBootCrud.bean.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//all logical operations are handled here
@Service
public class SubjectService {
    @Autowired
    public SubjectRepository subjectRepo;
    public List<Subject> getAllSubjects(){
        List<Subject> subjects = new ArrayList<>();
        subjectRepo.findAll().forEach(subjects::add);
        return subjects;
    }

    public void addSubject(Subject subject)  {
        subjectRepo.save(subject);
    }

    public void updateSubject(String id, Subject subject) {
        subjectRepo.save(subject);
    }

    public void deleteSubject(String id) {
        subjectRepo.deleteById(id);
    }

    public Subject getSearchedSubject(String id) {
        return  getAllSubjects().stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    /*public void getSearchedSubject(String id){
        getAllSubjects().stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }*/
}
