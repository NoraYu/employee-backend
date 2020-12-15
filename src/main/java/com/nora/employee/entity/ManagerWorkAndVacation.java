package com.nora.employee.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ManagerWorkAndVacation implements WorkAndVacation {
    @Override
    public Employee Work(int days, Employee e) {
        if(days>=260){
            e.setWorkDays(260);
            e.setVacationDays(Math.round((3.0/26.0)*e.getWorkDays()*100)/100);
        }
        else {
            e.setWorkDays(days);
            e.setVacationDays(Math.round((3.0/26.0)*e.getWorkDays()*100)/100);
        }
        return e;
    }


    @Override
    public String toString() {
        return "ManagerWorkAndVacation";
    }
}
