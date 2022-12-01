package com.example.learning.SpringBootCrud.service;
import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.repository.SubjectRepository;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {
    @Mock
    private SubjectRepository subjectRepository;
    private  SubjectService subjectService;
    private Subject subject;
    //AutoCloseable autoCloseable;
    @BeforeEach
    void setUp() {
        subject.setId("1");
        subject.setEmail("abc@gmail.com");
        subject.setName("ABC");
    }
    // JUnit test for saveEmployee method
    @DisplayName("JUnit test for saveEmployee method")
    @Test
    public void getAllSubjectsEmail(){
        // given - precondition or setup
        given(subjectRepository.findByEmail(subject.getEmail()))
                .willReturn(Optional.empty());

        given(subjectRepository.save(subject)).willReturn(subject);

        System.out.println(subjectRepository);
        System.out.println(subjectService);

        // when -  action or the behaviour that we are going test
        Subject savedSubject = subjectService.savedSubject(subject);

        System.out.println(savedSubject);
        // then - verify the output
        assertThat(savedSubject).isNotNull();
    }


    @Test
    void getAllSubjects(){
        subjectService.getAllSubjects();
        verify(subjectRepository).findAll();
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
    @Disabled//this method won't run
    void addSubject() {
    }

    @Test
    @Disabled//this method won't run
    void updateSubject() {
    }

    @Test
    @Disabled//this method won't run
    void deleteSubject() {
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