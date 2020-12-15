package com.nora.employee.entity;

import java.io.Serializable;


public class Employee implements Serializable {

    private WorkAndVacation workAndVacation;
    private int id;
    private String name;
    private double vacationDays;
    private double workDays;
    public Employee() {
    }
    public Employee(WorkAndVacation workAndVacation, String name, int id) {
        this.workAndVacation = workAndVacation;
        this.name=name;
        this.id=id;
    }

    public double getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(double vacationDays) {
        this.vacationDays = vacationDays;
    }

    public double getWorkDays() {
        return workDays;
    }

    public void setWorkDays(double workDays) {
        this.workDays = workDays;
    }

//    public WorkAndVacation getWorkAndVacation() {
//        return workAndVacation;
//    }

    public void setWorkAndVacation(WorkAndVacation workAndVacation) {
        this.workAndVacation = workAndVacation;
    }
    public void Work(int days){
        workAndVacation.Work(days,this);

    };
    public void TakeVacation(double days){
        workAndVacation.TakeVacation(days,this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
