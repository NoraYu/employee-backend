package com.nora.employee.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Component("managerWorkAndVacation")

public class ManagerWorkAndVacation implements WorkAndVacation {
    @Override
    public Employee Work(int days, Employee e) {
        if(days>=260){
            e.setWorkDays(260);
            e.setVacationDays((3.0/26.0)*e.getWorkDays());
        }
        else {
            e.setWorkDays(days);
            e.setVacationDays((3.0/26.0)*e.getWorkDays());
        }
        return e;
    }

}
