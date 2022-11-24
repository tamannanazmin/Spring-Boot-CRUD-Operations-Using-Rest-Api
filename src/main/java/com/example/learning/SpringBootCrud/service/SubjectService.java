package com.example.learning.SpringBootCrud.service;

import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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

    public ApiResponse addSubject(Subject subject)  {
        ApiResponse apiResponse = new ApiResponse();
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(subjectRepo.existsById(subject.getId())){
            apiResponse.setData("{}");
            apiResponse.setStatus(404);
            apiResponse.setError("{id already exist}");
        }

        else {
                subjectRepo.save(subject);
                apiResponse.setData(subject);
                apiResponse.setStatus(200);
                apiResponse.setError(null);
            }



        return apiResponse;
    }

    public ApiResponse updateSubject(String id, Subject subject) {
        ApiResponse apiResponse = new ApiResponse();
        if(!subjectRepo.existsById(id)){
            apiResponse.setData("{}");
            apiResponse.setStatus(404);
            apiResponse.setError("{Id does not exist}");
        }
        else {
            subjectRepo.save(subject);
            apiResponse.setData(subject);
            apiResponse.setStatus(200);
            apiResponse.setError(null);

        }
        return apiResponse;
    }

    public ApiResponse deleteSubject(String id) {
        ApiResponse apiResponse = new ApiResponse();
        if(!subjectRepo.existsById(id)){
            apiResponse.setData("{}");
            apiResponse.setStatus(404);
            apiResponse.setError("{Id does not exist}");
        }
        else {
            apiResponse.setData(subjectRepo.findById(id));
            apiResponse.setStatus(200);
            apiResponse.setError(null);
            subjectRepo.deleteById(id);

        }
        return apiResponse;
    }

    public Subject getSearchedSubject(String id) {
        return  getAllSubjects().stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    /*public void getSearchedSubject(String id){
        getAllSubjects().stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }*/
}
