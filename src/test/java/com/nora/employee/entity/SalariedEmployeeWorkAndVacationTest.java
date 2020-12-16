package com.nora.employee.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SalariedEmployeeWorkAndVacationTest {
    @Spy
    Employee e;
    @Spy
    Employee e2;
//    @Mock
    SalariedEmployeeWorkAndVacation se =new SalariedEmployeeWorkAndVacation();
    ManagerWorkAndVacation me=new ManagerWorkAndVacation();
    NormalEmployeeWorkAndVacation ne=new NormalEmployeeWorkAndVacation();
    @Test
    void SalariedEmployeeworkShouldWorks(){
//        when(e.getWorkDays()).thenReturn(260.0);

        Employee re=se.Work(260,e);
        e.setWorkDays(260);
        assertEquals(260.0,e.getWorkDays());
        assertEquals(15.0,re.getVacationDays());
        Employee re2=se.Work(130,e2);
        e2.setWorkDays(130);
        assertEquals(130.0,e2.getWorkDays());
        assertEquals(7.5,re2.getVacationDays());
    }
    @Test
    void ManagerworkShouldWorks(){
//        when(e.getWorkDays()).thenReturn(260.0);

        Employee re=me.Work(260,e);
        e.setWorkDays(260);
        assertEquals(260.0,e.getWorkDays());
        assertEquals(30.0,re.getVacationDays());
        Employee re2=me.Work(130,e2);
        e2.setWorkDays(130);
        assertEquals(130.0,e2.getWorkDays());
        assertEquals(15.0,re2.getVacationDays());

    }
    @Test
    void NormalShouldWorks(){
//        when(e.getWorkDays()).thenReturn(260.0);

        Employee re=ne.Work(260,e);
        e.setWorkDays(260);
        assertEquals(260.0,e.getWorkDays());
        assertEquals(10.0,re.getVacationDays());
        Employee re2=ne.Work(130,e2);
        e2.setWorkDays(130);
        assertEquals(130.0,e2.getWorkDays());
        assertEquals(5.0,re2.getVacationDays());
    }


}
