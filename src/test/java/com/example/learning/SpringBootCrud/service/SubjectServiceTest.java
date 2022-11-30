package com.example.learning.SpringBootCrud.service;
import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;

class SubjectServiceTest {
    @Mock
    private SubjectRepository subjectRepo;
    private AutoCloseable autoCloseable;
    private SubjectService underTest;

//    @BeforeEach
//    void setUp(){
//        autoCloseable = MockitoAnnotations.openMocks(this);
//        underTest = new SubjectService(subjectRepo);
//    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSubjects() {
//        //when
//        underTest.getAllSubjects();
//        //then
//        verify(subjectRepo).findAll();
//        //

    }


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