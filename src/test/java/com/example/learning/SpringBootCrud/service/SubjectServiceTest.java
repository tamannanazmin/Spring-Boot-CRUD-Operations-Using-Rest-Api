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
import java.util.stream.Collectors;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {
    @Mock
    private SubjectRepository subjectRepository;
    private  SubjectService subjectService;
    AutoCloseable autoCloseable;
    @BeforeEach
    void setUp() {
        AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);

        this.subjectService = new SubjectService(this.subjectRepository);
    }

    @AfterEach
    void tearDown() {
        try{
            this.autoCloseable.close();
        }catch (Exception e){
            e.printStackTrace();
        }
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