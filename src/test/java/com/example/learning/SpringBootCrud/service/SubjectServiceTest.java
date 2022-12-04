package com.example.learning.SpringBootCrud.service;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {
    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private  SubjectService subjectService;
    private SubjectDto subjectDto;
    //AutoCloseable autoCloseable;
    @BeforeEach
    void setUp() {
        subjectDto= subjectDto.builder()
                .id("1")
                .name("tamanna")
                .email("tama@gmail.com")
                .build();
    }
    // JUnit test for saveEmployee method
    @DisplayName("JUnit test method")
    @Test
    public void getAllSubjects(){
        List<Subject> subjects = new ArrayList<>();
        Subject subject = new Subject();
        subject.setId("1");
        subject.setEmail("abc@gmail.com");
        subject.setName("ABC");
        subjects.add(subject);

        when(subjectRepository.findAll()).thenReturn(subjects);
        //when
        List<SubjectDto> subjectDto = subjectService.getAllSubjects();
        //then
        assert subjectDto.size() == 1;

        /*verify(subjectRepo).findAll()
                .stream()
                .map(SubjectDto::convertEntityToDto)
                .collect(Collectors.toList());*/

    }

//    @Mock private SubjectRepository subjectRepo;
//
//    @InjectMocks
//    private SubjectService underTest;
//
//    @BeforeEach
//    void setUp(){
//        //autoCloseable = MockitoAnnotations.openMocks(this);
//        //underTest = new SubjectService();
//    }
////    @AfterEach
////    void tearDown() throws Exception {
////        autoCloseable.close();
////    }
//
//    @Test
//    //@Disabled//this method won't run
//    void canGetAllSubjects() {
//        List<Subject> subjects = new ArrayList<>();
//        Subject subject = new Subject();
//        subject.setId(String.valueOf(1));
//        subject.setEmail("abc@gmail.com");
//        subject.setName("ABC");
//        subjects.add(subject);
//
//        when(subjectRepo.findAll()).thenReturn(subjects);
//        //when
//        List<SubjectDto> subjectDtos = underTest.getAllSubjects();
//        //then
//        assert subjectDtos.size() == 1;
//        /*verify(subjectRepo).findAll()
//                .stream()
//                .map(SubjectDto::convertEntityToDto)
//                .collect(Collectors.toList());*/
//
//    }
//

    @Test
    //@Disabled//this method won't run
    void addSubject() {

        Subject subject = new Subject("1","tamanna","tamanna.naz@gmail.com");
        ApiResponse apiResponse= new ApiResponse(200, subject, null);

        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setEmail(subject.getEmail());

        //subjectService.addSubject(subjectDto);

        when(subjectRepository.save(subject)).thenReturn(subject);
        assertThat(subjectService.addSubject(subjectDto).getData()).isEqualTo(apiResponse.getData());


//        List<Subject> subjects = new ArrayList<>();
//        Subject subject = new Subject();
//        subject.setId("1");
//        subject.setEmail("abc@gmail.com");
//        subject.setName("ABC");
//        subjects.add(subject);
//        when(subjectRepository.save(subject)).thenReturn(subject);

        //assertThat(subjectService.addSubject(subject)).isEqualTo(subject);



        //when
         //List<SubjectDto> subjectDto = subjectService.addSubject();
        //then
        //assert subjectDto.size() == 1;

    }

    @Test
    void updateSubject() {
        Subject subject = new Subject("1","tanna","tamanna.naz@gmail.com");
        ApiResponse apiResponse= new ApiResponse(200, subject, null);

        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setEmail(subject.getEmail());
        when(subjectRepository.save(subject)).thenReturn(subject);
        subjectService.addSubject(subjectDto);
        assertThat(subjectService.updateSubject(subjectDto.getId(), subjectDto).getData()).isEqualTo(apiResponse.getData());
    }

    @Test
    @Disabled//this method won't run
    void deleteSubject() {
        Subject subject = new Subject("1","tanna","tamanna.naz@gmail.com");
        ApiResponse apiResponse= new ApiResponse(200, subject, null);

        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setEmail(subject.getEmail());

        when(subjectRepository.save(subject)).thenReturn(new Subject());
        subjectService.updateSubject(subjectDto.getId(),subjectDto);
        assertThat(subjectService.updateSubject(subjectDto.getId(), subjectDto).getData()).isEqualTo(apiResponse.getData());

    }

    @Test
    @Disabled//this method won't run
    void findByEmail() {
    }

    @Test
    @Disabled//this method won't run
    void exist() {
    }
}