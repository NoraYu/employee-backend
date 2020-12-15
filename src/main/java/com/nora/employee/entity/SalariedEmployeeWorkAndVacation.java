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
        e.setVacationDays(Math.round((15.0/260.0)*e.getWorkDays()*100)/100);
        return e;
    }
    @Override
    public Employee TakeVacation(double days, Employee e) {
        if(e.getVacationDays()<days){
            System.out.println("can not take leave");
        }
        else {
            e.setVacationDays(e.getVacationDays()-days);
        }
        return e;
    }

    @Override
    public String toString() {
        return "SalariedEmployeeWorkAndVacation";
    }
}
