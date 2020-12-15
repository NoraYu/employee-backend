package com.nora.employee.entity;

import org.springframework.stereotype.Component;



@Component
public class SalariedEmployeeWorkAndVacation implements WorkAndVacation{
    @Override
    public Employee Work(int days, Employee e) {
        if(days>=260){
            e.setWorkDays(260);
        }
        else {
            e.setWorkDays(days);
        }
        e.setVacationDays((15.0/260.0)*e.getWorkDays());
        System.out.println((15.0/260.0)*e.getWorkDays());
        return e;
    }

    @Override
    public String toString() {
        return "SalariedEmployeeWorkAndVacation";
    }
}
