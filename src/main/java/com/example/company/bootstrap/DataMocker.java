package com.example.company.bootstrap;

import com.example.company.beans.Employee;
import com.example.company.beans.Engineer;
import com.example.company.beans.Manager;
import com.example.company.beans.Secretary;
import com.example.company.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataMocker implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        Engineer a = new Engineer();
        a.setName("Matan");
        a.setSalary(5000);
        a.setSpeciality("Frontend");

        Secretary b = new Secretary();
        b.setName("Yonit");
        b.setSalary(4000);
        b.setOffice("HR");

        Manager c = new Manager();
        c.setName("Samir");
        c.setSalary(6000);
        c.setDepartment("Engineering");

        employeeService.addMultipleEmployees(List.of(a, b, c));
    }
}
