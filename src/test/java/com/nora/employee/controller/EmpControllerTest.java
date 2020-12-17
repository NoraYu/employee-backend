package com.nora.employee.controller;

import com.nora.employee.entity.DataBase;
import com.nora.employee.entity.Employee;
import com.nora.employee.entity.SalariedEmployeeWorkAndVacation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpController.class)
@AutoConfigureMockMvc(addFilters=false)
@ExtendWith(MockitoExtension.class)
class EmpControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataBase db;


//    @Spy
//    Employee e1;
//    @Spy
//    Employee e2;

    @Test
    void getAllEmpsShouldWork() throws Exception {
        List<Employee> list = new ArrayList<>();
        Employee e1=new Employee();Employee e2=new Employee();
        e1.setId(1);e1.setWorkDays(100); e1.setVacationDays(0);e1.setName("Nora");
        e2.setId(2);e2.setWorkDays(200);e2.setVacationDays(0);e2.setName("Jessie");
//        doReturn(0.0).when(e1).getVacationDays();
//        doReturn(0.0).when(e2).getVacationDays();
//        doReturn(100.0).when(e1).getWorkDays();
//        doReturn(200.0).when(e2).getWorkDays();
//        doReturn("Nora").when(e1).getName();
//        doReturn("Jessie").when(e2).getName();
//        doReturn(1).when(e1).getId();
//        doReturn(2).when(e2).getId();
        list.add(e1);list.add(e2);
        when(db.getDb()).thenReturn(list);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Nora\",\"vacationDays\":0.0,\"workDays\":100.0},{\"id\":2,\"name\":\"Jessie\",\"vacationDays\":0.0,\"workDays\":200.0}]"))
                .andReturn();
    }
    @Test
    void workShouldWork() throws Exception {
        List<Employee> list = new ArrayList<>();
        Employee e1=new Employee();Employee e2=new Employee();
        e1.setId(1);e1.setWorkDays(0); e1.setVacationDays(0);e1.setName("Nora");
        e1.setWorkAndVacation(new SalariedEmployeeWorkAndVacation());
        e2.setId(2);e2.setWorkDays(200);e2.setVacationDays(0);e2.setName("Jessie");
        list.add(e1);list.add(e2);
        when(db.getDb()).thenReturn(list);
        RequestBuilder request=MockMvcRequestBuilders.put("/1/work")
                .content("{\"days\":260}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Nora\",\"vacationDays\":15.0,\"workDays\":260.0}"))
                .andReturn();
    }
    @Test
    void takeVacationShouldWork() throws Exception {
        List<Employee> list = new ArrayList<>();
        Employee e1=new Employee();Employee e2=new Employee();
        e1.setId(1);e1.setWorkDays(260); e1.setVacationDays(15);e1.setName("Nora");
        e1.setWorkAndVacation(new SalariedEmployeeWorkAndVacation());
        e2.setId(2);e2.setWorkDays(200);e2.setVacationDays(0);e2.setName("Jessie");
        list.add(e1);list.add(e2);
        when(db.getDb()).thenReturn(list);
        RequestBuilder request=MockMvcRequestBuilders.put("/1/vacation")
                .content("{\"days\":10}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Nora\",\"vacationDays\":5.0,\"workDays\":260.0}"))
                .andReturn();
    }

    @Test
    void checkVacationShouldWork() throws Exception {
        List<Employee> list = new ArrayList<>();
        Employee e1=new Employee();Employee e2=new Employee();
        e1.setId(1);e1.setWorkDays(260); e1.setVacationDays(15);e1.setName("Nora");
        e1.setWorkAndVacation(new SalariedEmployeeWorkAndVacation());
        e2.setId(2);e2.setWorkDays(200);e2.setVacationDays(0);e2.setName("Jessie");
        list.add(e1);list.add(e2);
        when(db.getDb()).thenReturn(list);
        RequestBuilder request=MockMvcRequestBuilders.get("/1/vday")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("15.0"))
                .andReturn();
    }

}
