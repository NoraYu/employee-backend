package com.nora.employee.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorkAndVacationTest {
    @Spy
    Employee e;


    WorkAndVacation wa=new SalariedEmployeeWorkAndVacation();
    @Test
    void takeVacationShouldWork(){
        e.setVacationDays(15.0);
        assertEquals(wa.TakeVacation(10.0,e).getVacationDays(),5.0);
    }
    @Test
    void takeVacationShouldNotWork(){
        e.setVacationDays(15.0);
        assertEquals(wa.TakeVacation(16.0,e).getVacationDays(),15.0);
    }
}
