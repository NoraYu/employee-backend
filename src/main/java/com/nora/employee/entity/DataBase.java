package com.nora.employee.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBase {

    WorkAndVacation normalEmployeeWorkAndVacation =new NormalEmployeeWorkAndVacation();

    WorkAndVacation managerWorkAndVacation=new ManagerWorkAndVacation();

    WorkAndVacation salariedEmployeeWorkAndVacation= new SalariedEmployeeWorkAndVacation();

    private List<Employee> db=new ArrayList<>();

    public DataBase() {
        for(int i=1;i<=10;i++){
            Employee e=new Employee(salariedEmployeeWorkAndVacation,"salaried Employee "+i,i);
//            e.Work(200);
//            System.out.println("v days :"+e.getVacationDays());
            db.add(e);
        }
        for(int i=1;i<=10;i++){
            Employee e=new Employee(managerWorkAndVacation,"manager "+i,i+10);
            db.add(e);
        }
        for(int i=1;i<=10;i++){
            Employee e=new Employee(normalEmployeeWorkAndVacation,"Hourly Employee "+i,i+20);
            db.add(e);
        }
    }

    public List<Employee> getDb() {
        return db;
    }
}
