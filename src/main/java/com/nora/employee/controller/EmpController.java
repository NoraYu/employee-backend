package com.nora.employee.controller;

import com.nora.employee.entity.DataBase;
import com.nora.employee.entity.Employee;
import com.nora.employee.entity.RequestDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmpController {
    @Autowired
    DataBase db;

    @GetMapping(value = {"/"}, produces = "application/json")
    public ResponseEntity<List<Employee>> allemps() {
        return new ResponseEntity<>(db.getDb(), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}/vday"}, produces = "application/json")
    public ResponseEntity<Double> vday(@PathVariable(name = "id") long id) {
        Employee theEmp = new Employee();
        Double result=0.0;
        for (Employee e : db.getDb()) {
            if (e.getId() == id) {
                result=e.getVacationDays();
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = {"/{id}/work"}, produces = "application/json")
    public ResponseEntity<Employee> work(@PathVariable(name = "id") long id, @RequestBody RequestDay rq) {
        db.getDb().stream().filter(e -> e.getId() == id).collect(Collectors.toList()).forEach(employee -> employee.Work((int)rq.getDays()));
        Employee theEmp = new Employee();
        for (Employee e : db.getDb()) {
            if (e.getId() == id) {
                theEmp = e;
            }
        }
        return new ResponseEntity<>(theEmp, HttpStatus.OK);
    }

    @PostMapping(value = {"/{id}/vacation"}, produces = "application/json")
    public ResponseEntity<Employee> takeVacation(@PathVariable(name = "id") long id, @RequestBody RequestDay rq) {
        db.getDb().stream().filter(e -> e.getId() == id).collect(Collectors.toList()).forEach(employee -> employee.TakeVacation(rq.getDays()));
        Employee theEmp = new Employee();
        for (Employee e : db.getDb()) {
            if (e.getId() == id) {
                theEmp = e;
            }}
            return new ResponseEntity<>(theEmp, HttpStatus.OK);
        }

    }

