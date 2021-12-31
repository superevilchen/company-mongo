package com.example.company.services;

import com.example.company.beans.Employee;
import com.example.company.beans.Manager;
import com.example.company.repos.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void addEmployee(Employee e){
        employeeRepository.insert(e);
        System.out.println("added employee");
    }

    @Transactional
    public void updateEmployee(String id, Employee e) throws Exception {
        Employee fromDB = employeeRepository.findById(id).orElseThrow(() -> new Exception("couldnt get employee"));

        fromDB = e;
    }

    public void deleteEmployee(String id) throws Exception {
        if (!employeeRepository.existsById(id)){
            throw new Exception("couldnt get employee");
        }
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getOneEmployee(String id) throws Exception {
        Employee fromDB = employeeRepository.findById(id).orElseThrow(() -> new Exception("couldnt get employee"));
        return fromDB;
    }

    public double getAverageSalary(){
        List<Employee> employees = getEmployees();

        double avgSalary = employees.stream().mapToDouble(c -> c.getSalary()).sum();
        return avgSalary / employees.size();
    }

    public double getManagementAvgSalary(){
        List<Employee> employees = getEmployees().stream().filter(c -> c instanceof Manager).collect(Collectors.toList());

        double avgSalary = employees.stream().filter(c -> c instanceof Manager).mapToDouble(c -> c.getSalary()).sum();
        return avgSalary / employees.size();
    }

    public double getYearlyPayment(){
        List<Employee> employees = getEmployees();

        return (employees.stream().mapToDouble(c -> c.getSalary()).sum()) * 12;
    }

    public int getTotalNumOfEmployees(){
        return getEmployees().size();
    }

    public int getTotalNumOfManagers(){
        return (int) getEmployees().stream().filter(c -> c instanceof Manager).count();
    }
}
