package com.nora.employee.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("salariedEmployeeWorkAndVacation")

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

}
