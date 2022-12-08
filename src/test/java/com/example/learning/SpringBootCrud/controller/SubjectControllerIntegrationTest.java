package com.example.learning.SpringBootCrud.controller;

import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.internal.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.support.NullValue;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = {WebApplicationInitializer.class})
//@WebAppConfiguration
class SubjectControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp() throws Exception{
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();+
        subjectRepository.deleteAll();
    }
    @Test
    public void getSubject() throws Exception{
        // given - precondition or setup
        List<Subject> subjects= new ArrayList<>();
        subjects.add(Subject.builder().id("Ramesh").name("Fadatare").email("ramesh@gmail.com").build());
        subjects.add(Subject.builder().id("Tony").name("Stark").email("tony@gmail.com").build());
        subjectRepository.saveAll(subjects);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/subjects"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(subjects.size())));

        this.mockMvc.perform(get("/subjects")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addSubject() throws Exception{
        Subject subject =Subject.builder()
                .id("11")
                .name("tama")
                .email("k@gmail.com")
                .build();
        ResultActions response = mockMvc.perform(post("/subjects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(subject)));

        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("200"))
                .andExpect(jsonPath("$.data.id", is(subject.getId())))
                .andExpect(jsonPath("$.data.name", is(subject.getName())))
                .andExpect(jsonPath("$.data.email", is(subject.getEmail())))
                .andExpect(jsonPath("$.error").value(nullValue()));

    }
    @Test
    public void updateSubject() throws Exception{
        // given - precondition or setup
        Subject savedSubject = Subject.builder()
                .id("19")
                .name("Fadatare")
                .email("ramesh@gmail.com")
                .build();
        subjectRepository.save(savedSubject);

        Subject updatedSubject = Subject.builder()
                .id("19")
                .name("Jadhav")
                .email("ram@gmail.com")
                .build();

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/subjects/{id}", savedSubject.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedSubject)));


        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status").value("200"))
                .andExpect(jsonPath("$.data.id", is(updatedSubject.getId())))
                .andExpect(jsonPath("$.data.name", is(updatedSubject.getName())))
                .andExpect(jsonPath("$.data.email", is(updatedSubject.getEmail())));
    }
    @Test
    public void deleteSubject() throws Exception{
        // given - precondition or setup
        Subject subject = Subject.builder()
                .id("19")
                .name("Fadatare")
                .email("ramesh@gmail.com")
                .build();
        subjectRepository.save(subject);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/subjects/{id}", subject.getId()));


        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.status").value("200"))
                .andExpect(jsonPath("$.error").value(nullValue()));
    }
}



//        this.mockMvc.perform(post("/subjects")).andDo(print())
//                .andExpect(status().isOk()).andExpect((ResultMatcher) content().contentType("application/json;charset=UTF-8"))
//                .andExpect(jsonPath("$.id").value("22"))
//                .andExpect(jsonPath("$.name").value("myname"))
//                .andExpect(jsonPath("$.email").value("em@gmail.com"));