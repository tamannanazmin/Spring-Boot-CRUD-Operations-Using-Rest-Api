package com.example.learning.SpringBootCrud.service;

import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
//import ai.openai.OpenAI;


import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//all logical operations are handled here
@Service
public class SubjectService {

    @Autowired
    public SubjectRepository subjectRepo;
//    public SubjectService(SubjectRepository subjectRepo){
//        this.subjectRepo=subjectRepo;
//    }



//    //private final OpenAi api = new OpenAI(OpenAIConfig.API_KEY);
//
//    public String generateText(String prompt) {
//        CompletionRequest request = new CompletionRequest.Builder()
//                .prompt(prompt)
//                .build();
//
//        try {
//            CompletionResponse response = api.getCompletion(request);
//            return response.getChoices().get(0).getText();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public ApiResponse getAllSubjects() {
        ApiResponse apiResponse = new ApiResponse();
//        subjectRepo.findAll()
//                .stream()
//                .map(SubjectDto::convertEntityToDto)
//                .collect(Collectors.toList());
        apiResponse.setError(null);
        apiResponse.setStatus(200);
        apiResponse.setData(subjectRepo.findAll());
        return apiResponse;

    }

    public ApiResponse addSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();

        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setEmail(subjectDto.getEmail());
        ApiResponse apiResponse = new ApiResponse();
        if(this.findByEmail(subject.getEmail())==null){

            subjectRepo.save(subject);
        }
        else {
            apiResponse.setError("{email already exist, Enter another email}");
            return apiResponse;
        }
        apiResponse.setData(subject);
        apiResponse.setStatus(200);
        return apiResponse;

        /*try {
            subjectRepo.save(subject);
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setStatus(404);
             if (e.getMessage().contains("UK_")) {
                 apiResponse.setError("{email already exist}");
                 return apiResponse;
             } else {
                 apiResponse.setError(e.getMessage());
             }
             return apiResponse;
        }*/
//        try {
//        if(this.findByEmail(subject.getEmail())==null){
//        } catch (DataIntegrityViolationException de) {
//            de.printStackTrace();
//            apiResponse.setError("{email already exist}");
//            return apiResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            apiResponse.setStatus(404);
//            apiResponse.setError(e.getMessage());
//            return apiResponse;
//        }


        /*ApiResponse apiResponse = new ApiResponse();
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
        return apiResponse;*/
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
            apiResponse.setError("{id does not exist}");
        }
        else {
            apiResponse.setData(subjectRepo.findById(id));
            apiResponse.setStatus(200);
            apiResponse.setError(null);
            subjectRepo.deleteById(id);

        }
        return apiResponse;
    }
    public Subject findByEmail(String email){
        return subjectRepo.findByEmail(email).orElse(null);
    }

    public boolean exist(String email){
        return subjectRepo.existsByEmail(email);
    }


}
