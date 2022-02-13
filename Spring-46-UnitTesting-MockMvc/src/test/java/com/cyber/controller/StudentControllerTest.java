package com.cyber.controller;

import com.cyber.entity.Student;
import com.cyber.service.StudentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest //all the context [like beans] will be uploaded
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean //bring the instance of StudentService
    StudentService studentService;

    @Test
    void getStudent_service() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 0,\"firstName\": \"mike\",\"lastName\": \"smith\",\"age\": 120}"))
                .andReturn();
    }

    @Test
    void jsonAssert1() throws JSONException {
        String actual = "{\"id\": 0,\"firstName\": \"mike\",\"lastName\": \"smith\",\"age\": 120}";
        String expected = "{\"id\": 0,\"firstName\": \"mike\",\"lastName\": \"smith\",\"age\": 120}";

        JSONAssert.assertEquals(expected,actual,true);
    }

    @Test
    void jsonAssert2() throws JSONException {
        String actual = "{\"id\": 0,\"firstName\": \"mike\",\"lastName\": \"smith\",\"age\": 120}";
        String expected = "{\"id\": 0,\"firstName\": \"mike\",\"lastName\": \"smith\"}";

        JSONAssert.assertEquals(expected,actual,false);
    }

    @Test
    void getStudent_data() throws Exception {
        //1. mock the service
        when(studentService.getStudent_data()).thenReturn(Arrays.asList(
                new Student("mike","mike",25),
                new Student("tom","tom",32)
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\": 0,\"firstName\": \"mike\",\"lastName\": \"mike\",\"age\": 25}," +
                                                     "{\"id\": 0,\"firstName\": \"tom\",\"lastName\": \"tom\",\"age\": 32}]"))
                .andReturn();
    }

}