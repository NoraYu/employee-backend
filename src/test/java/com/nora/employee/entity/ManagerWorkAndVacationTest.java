package com.nora.employee.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ManagerWorkAndVacationTest {
    ManagerWorkAndVacation me=new ManagerWorkAndVacation();
    @Spy
    Employee e;
    @Spy
    Employee e2;
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

}
