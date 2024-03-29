//package com.example.learning.SpringBootCrud.controller;
//
//import com.example.learning.SpringBootCrud.bean.Subject;
//import com.example.learning.SpringBootCrud.dto.SubjectDto;
//import com.example.learning.SpringBootCrud.service.SubjectService;
//import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//////@RunWith(SpringRunner.class)
//////@WebMvcTest(value = SubjectController.class)
////class SubjectControllerUnitTest extends AbstractTest{
////    @Override
////    @Before
////    public void setUp() {
////        super.setUp();
////    }
//////    @Test
//////    public void getProductsList() throws Exception {
//////        String uri = "/subjects";
//////        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//////                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//////
//////        int status = mvcResult.getResponse().getStatus();
//////        assertEquals(200, status);
//////        String content = mvcResult.getResponse().getContentAsString();
//////        SubjectDto[] subjectlist = super.mapFromJson(content, SubjectDto[].class);
//////        assertTrue(subjectlist.length > 0);
//////    }
////    @Test
////    public void createProduct() throws Exception {
////        String URI = "/subjects";
////        SubjectDto product = new SubjectDto();
////        product.setId("3");
////        product.setName("Ginger");
////        product.setEmail("we@gmail.com");
////        String inputJson = super.mapToJson(product);
////        System.out.println("input: "+inputJson);
////
////        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI);
////        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
////        System.out.println("result: "+mvcResult);
////
////        int status = mvcResult.getResponse().getStatus();
////        assertEquals(200, status);
////        String content = mvcResult.getResponse().getContentAsString();
////        assertEquals(content, "Product is created successfully");
////    }
//////    @Test
//////    public void updateProduct() throws Exception {
//////        String uri = "/products/2";
//////        Product product = new Product();
//////        product.setName("Lemon");
//////        String inputJson = super.mapToJson(product);
//////        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//////                .contentType(MediaType.APPLICATION_JSON_VALUE)
//////                .content(inputJson)).andReturn();
//////
//////        int status = mvcResult.getResponse().getStatus();
//////        assertEquals(200, status);
//////        String content = mvcResult.getResponse().getContentAsString();
//////        assertEquals(content, "Product is updated successsfully");
//////    }
//////    @Test
//////    public void deleteProduct() throws Exception {
//////        String uri = "/products/2";
//////        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//////        int status = mvcResult.getResponse().getStatus();
//////        assertEquals(200, status);
//////        String content = mvcResult.getResponse().getContentAsString();
//////        assertEquals(content, "Product is deleted successsfully");
//////    }
////
////}
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = SubjectController.class)
//class SubjectControllerUnitTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SubjectService subjectService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void ShouldAddSubjectIfFound() throws Exception{
//        SubjectDto subjectDto= new SubjectDto();
//        subjectDto.setId("23");
//        subjectDto.setName("tama");
//        subjectDto.setEmail("y@gmail.com");
//
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setData(subjectDto);
//        apiResponse.setStatus(200);
//        apiResponse.setError(null);
//
//        String URI = "/subjects";
//        Mockito.when(subjectService.addSubject(Mockito.any(SubjectDto.class))).thenReturn(apiResponse);
//
//        ResultActions response = mockMvc.perform(post("/subjects")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(subjectDto)));
//
//        //RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI);
//
//
//        //MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        //MockHttpServletResponse response = result.getResponse();
//        //assertEquals(apiResponse.getError(), response.getErrorMessage());
//        response.andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value("200"))
//                .andExpect(jsonPath("$.data.id", is(subjectDto.getId())))
//                .andExpect(jsonPath("$.data.name", is(subjectDto.getName())))
//                .andExpect(jsonPath("$.data.email", is(subjectDto.getEmail())))
//                .andExpect(jsonPath("$.error").value(nullValue()));
//    }
//    @Test
//    public void ShouldNotAddSubjectIfNameHasLessThanTwoCharacter() throws Exception{
//        SubjectDto subjectDto= new SubjectDto();
//        subjectDto.setId("23");
//        subjectDto.setName("p");
//        subjectDto.setEmail("y@gmail.com");
//
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setData(subjectDto);
//        apiResponse.setStatus(400);
//        apiResponse.setError("User name should have at least 2 characters");
//
//        String URI = "/subjects";
//        Mockito.when(subjectService.addSubject(subjectDto)).thenReturn(apiResponse);
//        ResultActions response = mockMvc.perform(post("/subjects")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(subjectDto)));
//        response.andDo(print())
//                .andExpect(jsonPath("$.status").value("400"))
//                .andExpect(jsonPath("$.error").value("User name should have at least 2 characters"));
//
//
////        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI);
////        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////        MockHttpServletResponse response = result.getResponse();
////        System.out.println("hi error:"+response.getContentAsString());
////        assertEquals(apiResponse.getError(), response.getErrorMessage());
//
//
//    }
//    @Test
//    public void ShouldNotAddSubjectIfEmailIsNotValid() throws Exception{
//        SubjectDto subjectDto= new SubjectDto();
//        subjectDto.setId("23");
//        subjectDto.setName("paaa");
//        subjectDto.setEmail("yasdail.com");
//
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setData(subjectDto);
//        apiResponse.setStatus(400);
//        apiResponse.setError("Please enter valid email");
//
//        String URI = "/subjects";
//        Mockito.when(subjectService.addSubject(subjectDto)).thenReturn(apiResponse);
//        ResultActions response = mockMvc.perform(post("/subjects")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(subjectDto)));
//        response.andDo(print())
//                .andExpect(jsonPath("$.status").value("400"))
//                .andExpect(jsonPath("$.error").value("Please enter valid email"));
//    }
//    @Test
//    public void ShouldNotAddSubjectIfEmailIsEmpty() throws Exception{
//        SubjectDto subjectDto= new SubjectDto();
//        subjectDto.setId("23");
//        subjectDto.setName("paaa");
//        subjectDto.setEmail("");
//
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setData(subjectDto);
//        apiResponse.setStatus(400);
//        apiResponse.setError("Email Can not be Empty");
//
//        String URI = "/subjects";
//        Mockito.when(subjectService.addSubject(subjectDto)).thenReturn(apiResponse);
//        ResultActions response = mockMvc.perform(post("/subjects")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(subjectDto)));
//        response.andDo(print())
//                .andExpect(jsonPath("$.status").value("400"))
//                .andExpect(jsonPath("$.error").value("Email Can not be Empty"));
//    }
//    @Test
//    public void ShouldNotAddSubjectIfNameIsNotCorrect() throws Exception{
//        SubjectDto subjectDto= new SubjectDto();
//        subjectDto.setId("23");
//        subjectDto.setName("paaa$123");
//        subjectDto.setEmail("abc@gmail.com");
//
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setData(subjectDto);
//        apiResponse.setStatus(400);
//        apiResponse.setError("Name is not correct, Enter again please");
//
//        String URI = "/subjects";
//        Mockito.when(subjectService.addSubject(subjectDto)).thenReturn(apiResponse);
//        ResultActions response = mockMvc.perform(post("/subjects")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(subjectDto)));
//        response.andDo(print())
//                .andExpect(jsonPath("$.status").value("400"))
//                .andExpect(jsonPath("$.error").value("Name is not correct, Enter again please"));
//    }
//    @Test
//    public void ShouldNotAddSubjectIfNameIsEmpty() throws Exception{
//        SubjectDto subjectDto= new SubjectDto();
//        subjectDto.setId("23");
//        subjectDto.setName(null);
//        subjectDto.setEmail("abc@gmail.com");
//
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setData(subjectDto);
//        apiResponse.setStatus(400);
//        apiResponse.setError("Name Can not be Empty");
//
//        String URI = "/subjects";
//        Mockito.when(subjectService.addSubject(subjectDto)).thenReturn(apiResponse);
//        ResultActions response = mockMvc.perform(post("/subjects")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(subjectDto)));
//        response.andDo(print())
//                .andExpect(jsonPath("$.status").value("400"))
//                .andExpect(jsonPath("$.error").value("Name Can not be Empty"));
//    }
//
//    @Test
//    public void getAllSubjectTest() throws Exception {
//
//        SubjectDto subjectDto= new SubjectDto();
//        subjectDto.setId("23");
//        subjectDto.setName("adf");
//        subjectDto.setEmail("y@gmail.com");
//
//        SubjectDto subjectDto2= new SubjectDto();
//        subjectDto2.setId("24");
//        subjectDto2.setName("adf");
//        subjectDto2.setEmail("l@gmail.com");
//
//        List<SubjectDto> subjectList = new ArrayList<>();
//        subjectList.add(subjectDto);
//        subjectList.add(subjectDto2);
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setData(subjectList);
//        apiResponse.setStatus(200);
//        apiResponse.setError(null);
//
//        Mockito.when(subjectService.getAllSubjects()).thenReturn(apiResponse);
//
//        String URI = "/subjects";
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                URI).accept(
//                MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        int outputInJson = result.getResponse().getStatus();
//
//        assertThat(outputInJson).isEqualTo(apiResponse.getStatus());
//    }
//
//
//}