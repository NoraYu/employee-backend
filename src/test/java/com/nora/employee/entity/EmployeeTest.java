package com.nora.employee.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
//    @Autowired
//    @Qualifier("managerWorkAndVacation")
    ManagerWorkAndVacation m=new ManagerWorkAndVacation();
    NormalEmployeeWorkAndVacation n=new NormalEmployeeWorkAndVacation();
    @Spy
    Employee employee;
    @Test
    void ManagerSHouldWork(){
        employee=new Employee(m,"Nora",1);
        assertEquals(1, employee.getId());
        assertEquals("Nora", employee.getName());
        employee.Work(260);
        assertEquals(260.0, employee.getWorkDays());
        assertEquals(30.0, employee.getVacationDays());
        employee.TakeVacation(20.0);
        assertEquals(10.0, employee.getVacationDays());
    }
    @Test
    void NormalEmpShouldWork(){
        employee=new Employee(n,"Jessie",2);
        assertEquals(2, employee.getId());
        assertEquals("Jessie", employee.getName());
        employee.Work(260);
        assertEquals(260.0, employee.getWorkDays());
        assertEquals(10.0, employee.getVacationDays());
        employee.TakeVacation(4.0);
        assertEquals(6.0, employee.getVacationDays());
    }

}
