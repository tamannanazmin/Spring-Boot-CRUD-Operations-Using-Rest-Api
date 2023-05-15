//package com.example.learning.SpringBootCrud.service;
//import com.example.learning.SpringBootCrud.bean.Subject;
//import com.example.learning.SpringBootCrud.dto.SubjectDto;
//import com.example.learning.SpringBootCrud.repository.SubjectRepository;
//import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
//class SubjectServiceTest {
//    @Mock
//    private SubjectRepository subjectRepository;
//
//    @InjectMocks
//    private  SubjectService subjectService;
//    private SubjectDto subjectDto;
//
//    @DisplayName("JUnit test method")
//    @Test
//    public void getAllSubjects(){
//        List<Subject> subjects = new ArrayList<>();
//        Subject subject = new Subject();
//        subject.setId("1");
//        subject.setEmail("as@gmail.com");
//        subject.setName("tamanna");
//        subjects.add(subject);
//
//        when(subjectRepository.findAll()).thenReturn(subjects);
//        //when
//        ApiResponse apiResponse = subjectService.getAllSubjects();
//        System.out.println("get all data"+subjectDto);
//        //then
//    }
//
//    @Test
//    //@Disabled//this method won't run
//    void addSubject() {
//        Subject subject = new Subject("4","tamanna","tamanna.naz@gmail.com");
//        ApiResponse apiResponse= new ApiResponse(200, subject, null);
//
//        SubjectDto subjectDto = new SubjectDto();
//        subjectDto.setId(subject.getId());
//        subjectDto.setName(subject.getName());
//        subjectDto.setEmail(subject.getEmail());
//
//        when(subjectRepository.save(subject)).thenReturn(subject);
//        assertThat(subjectService.addSubject(subjectDto).getData()).isEqualTo(apiResponse.getData());
//    }
//
//    @Test
//    //@Disabled
//    void ShouldNotUpdateSubjectIfNotFound() {
//        Subject subject = new Subject();
//        ApiResponse apiResponse= new ApiResponse(404, "{}", "{id does not exist}");
//
//        SubjectDto subjectDto = new SubjectDto();
//        subjectDto.setId(subject.getId());
//        subjectDto.setName(subject.getName());
//        subjectDto.setEmail(subject.getEmail());
//
//        when(subjectRepository.save(subject)).thenReturn(subject);
//        when(subjectRepository.existsById(subjectDto.getId())).thenReturn(false);
//
//        ApiResponse actualResponse = subjectService.updateSubject(subjectDto.getId(), subjectDto);
//        assertThat(actualResponse.getStatus()).isEqualTo(apiResponse.getStatus());
//    }
//    @Test
//        //@Disabled
//    void ShouldUpdateSubjectIfFound() {
//        Subject subject = new Subject("1","tanna","tamanna.naz@gmail.com");
//        ApiResponse apiResponse= new ApiResponse(200, subject, null);
//
//        SubjectDto subjectDto = new SubjectDto();
//        subjectDto.setId(subject.getId());
//        subjectDto.setName(subject.getName());
//        subjectDto.setEmail(subject.getEmail());
//
//        when(subjectRepository.save(subject)).thenReturn(subject);
//        when(subjectRepository.existsById(subjectDto.getId())).thenReturn(true);
//        subjectService.addSubject(subjectDto);
//        ApiResponse actualResponse = subjectService.updateSubject(subjectDto.getId(), subjectDto);
//        assertThat(actualResponse.getData()).isEqualTo(apiResponse.getData());
//    }
//    @Test
//   // @Disabled//this method won't run
//    void ShouldDeleteSubjectIfFound() {
//        Subject subject = new Subject("1","tamanna","tamanna.naz@gmail.com");
//        ApiResponse apiResponse= new ApiResponse(200, subject, null);
//
//        SubjectDto subjectDto = new SubjectDto();
//        subjectDto.setId(subject.getId());
//        subjectDto.setName(subject.getName());
//        subjectDto.setEmail(subject.getEmail());
//
//        when(subjectRepository.save(subject)).thenReturn(new Subject());
//        when(subjectRepository.existsById(subjectDto.getId())).thenReturn(true);
//        subjectService.addSubject(subjectDto);
//        assertThat(subjectService.deleteSubject(subjectDto.getId()).getStatus()).isEqualTo(apiResponse.getStatus());
//    }
//    @Test
//        // @Disabled//this method won't run
//    void ShouldNotDeleteSubjectIfNotFound() {
//        Subject subject = new Subject("1","tamanna","tamanna.naz@gmail.com");
//        ApiResponse apiResponse= new ApiResponse(404, "{}", "{id does not exist}");
//
//        SubjectDto subjectDto = new SubjectDto();
//        subjectDto.setId(subject.getId());
//        subjectDto.setName(subject.getName());
//        subjectDto.setEmail(subject.getEmail());
//
//        when(subjectRepository.save(subject)).thenReturn(new Subject());
//        when(subjectRepository.existsById(subjectDto.getId())).thenReturn(false);
//        subjectService.addSubject(subjectDto);
//        assertThat(subjectService.deleteSubject(subjectDto.getId()).getStatus()).isEqualTo(apiResponse.getStatus());
//    }
//
//    @Test
//    @Disabled//this method won't run
//    void findByEmail() {
//    }
//
//    @Test
//    @Disabled//this method won't run
//    void exist() {
//    }
//}