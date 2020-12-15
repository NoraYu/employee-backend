package com.nora.employee.entity;

public interface WorkAndVacation {
    Employee Work(int days, Employee e);
    public abstract Employee TakeVacation(double days, Employee e);
}
