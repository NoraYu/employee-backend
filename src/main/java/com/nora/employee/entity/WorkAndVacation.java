package com.nora.employee.entity;

public interface WorkAndVacation {
    Employee Work(int days, Employee e);
//    public abstract Employee TakeVacation(double days, Employee e);
    default Employee TakeVacation(double days, Employee e) {
        if(e.getVacationDays()<days){
            System.out.println("can not take leave");
        }
        else {
            e.setVacationDays(e.getVacationDays()-days);
        }
        return e;
    }
}
