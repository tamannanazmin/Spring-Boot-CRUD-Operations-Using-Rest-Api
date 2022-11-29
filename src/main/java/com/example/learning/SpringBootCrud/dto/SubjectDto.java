package com.example.learning.SpringBootCrud.dto;
import com.example.learning.SpringBootCrud.bean.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data//we do not need to use getter setter method for this
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

    private String id;

    @NotEmpty(message = "Name Can not be Empty")
    @Size(min = 2, message = "User name should have at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]+", message = "Name is not correct, Enter again please")
    private String name;

    @NotEmpty(message = "Email Can not be Empty")
    @Email(message = "Please enter valid email")
    private String email;

//    @NotEmpty(message = "text Can not be Empty")
//    private String test;


    //DTO using
    public static SubjectDto convertEntityToDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setEmail(subject.getEmail());
        return subjectDto;
    }
}
