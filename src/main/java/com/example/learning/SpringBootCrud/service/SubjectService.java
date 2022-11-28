package com.example.learning.SpringBootCrud.service;

import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//all logical operations are handled here
@Service
public class SubjectService {

    @Autowired
    public SubjectRepository subjectRepo;

    public List<SubjectDto> getAllSubjects() {
        //List<Subject> subjects = new ArrayList<>();
        //subjectRepo.findAll().forEach(subjects::add);
        //return subjects;
        return subjectRepo.findAll()
                .stream()
                .map(SubjectDto::convertEntityToDto)
                .collect(Collectors.toList());
    }

//    public Subject createUser(Subject subject) {
//        return subjectRepo.save(subject);
//    }

    public ApiResponse addSubject(SubjectDto subjectDto) {//TODO remove all the if else validation
        Subject subject = new Subject();

        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setEmail(subjectDto.getEmail());


        ApiResponse apiResponse = new ApiResponse();
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(subjectRepo.existsById(subject.getId())){
            apiResponse.setData("{}");
            apiResponse.setStatus(404);
            apiResponse.setError("{id already exist}");
        }
        else if(subject.getEmail() == null || subject.getEmail().isEmpty() || !Pattern.compile(emailRegex).matcher(subject.getEmail()).matches()){
            apiResponse.setData("{}");
            apiResponse.setStatus(404);
            apiResponse.setError("{Invalid Email. Please Try again}");
        }

        else if(subject.getName().isEmpty()){
            apiResponse.setData("{}");
            apiResponse.setStatus(404);
            apiResponse.setError("{Name Can not be Blank}");
        }
        else {
            subjectRepo.save(subject);
            apiResponse.setData(subject);
            apiResponse.setStatus(200);
            apiResponse.setError(null);
        }
        return apiResponse;
    }

    public ApiResponse updateSubject(String id, SubjectDto subjectDto) {
        Subject subject = new Subject();

        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setEmail(subjectDto.getEmail());

        ApiResponse apiResponse = new ApiResponse();
        if(!subjectRepo.existsById(id)){
            apiResponse.setData("{}");
            apiResponse.setStatus(404);
            apiResponse.setError("{id does not exist}");
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

//    public Subject getSearchedSubject(String id) {
//        return  getAllSubjects().stream().filter(t -> t.getId().equals(id)).findFirst().get();
//    }

    /*public void getSearchedSubject(String id){
        getAllSubjects().stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }*/
}
