package com.example.learning.SpringBootCrud.controller;

import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.dto.SubjectDto;
import com.example.learning.SpringBootCrud.service.SubjectService;
import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SubjectController.class)
class SubjectControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    @Test
    public void testAdd() throws Exception{
        SubjectDto subjectDto= new SubjectDto();
        subjectDto.setId("23");
        subjectDto.setName("adf");
        subjectDto.setEmail("y@gmail.com");

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(subjectDto);
        apiResponse.setStatus(200);
        apiResponse.setError(null);


        String URI = "/subjects";
        Mockito.when(subjectService.addSubject(Mockito.any(SubjectDto.class))).thenReturn(apiResponse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(200, apiResponse.getStatus());


    }

}