package com.example.company.beans;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Manager extends Employee{

    private String department;

    @Override
    public String toString() {
        return "Manager{ name = " + getName() + ", salary= " + getSalary() + ", department= " + department;
    }
}
