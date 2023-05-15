//package com.example.learning.SpringBootCrud.repository;
//
//import com.example.learning.SpringBootCrud.bean.Subject;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
//class SubjectRepositoryTest {
//
//    @Autowired
//    private SubjectRepository underTest;
//
//    @AfterEach
//    void tearDown(){
//        underTest.deleteAll();
//    }
//
//    @Test
//    void itShouldCheckIfSubjectEmailExists() {
//        //given
//        String email = "jamila@gmail.com";
//        Subject subject = new Subject(
//                "2",
//                "Jamila",
//                "jamila@gmail.com"
//        );
//        underTest.save(subject);
//
//        //when
//        boolean expected = underTest.existsByEmail(email);
//        //then
//        assertThat(expected).isTrue();
//    }
//
//
//    @Test
//    void itShouldCheckIfSubjectEmailDoesNotExists() {
//        //given
//        String email = "jamila@gmail.com";
//        //when
//        boolean expected = underTest.existsByEmail(email);
//        //then
//        assertThat(expected).isFalse();
//    }
//}