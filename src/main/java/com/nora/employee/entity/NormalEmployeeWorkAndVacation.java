package com.nora.employee.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NormalEmployeeWorkAndVacation implements WorkAndVacation  {
    @Override
    public Employee Work(int days, Employee e) {
        if(days>=260){
            e.setWorkDays(260);
            e.setVacationDays((1.0/26.0)*e.getWorkDays());
        }
        else {
            e.setWorkDays(days);
            e.setVacationDays((1.0/26.0)*e.getWorkDays());
        }
        return e;
    }


    @Override
    public String toString() {
        return "NormalEmployeeWorkAndVacation";
    }
}
