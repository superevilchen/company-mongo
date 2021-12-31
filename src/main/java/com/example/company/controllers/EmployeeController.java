package com.example.company.controllers;

import com.example.company.beans.Employee;
import com.example.company.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EmployeeController.BASE_URL)
@RequiredArgsConstructor
public class EmployeeController {

    protected static final String BASE_URL = "/api/v1/company";
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable String id) throws Exception {
        return employeeService.getOneEmployee(id);
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee e){
        employeeService.addEmployee(e);
    }

    @PutMapping("update/{id}")
    public void updateEmployee(@PathVariable String id, @RequestBody Employee e) throws Exception {
        employeeService.updateEmployee(id, e);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id) throws Exception {
        employeeService.deleteEmployee(id);
    }
}
