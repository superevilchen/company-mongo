package com.example.company.beans;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Engineer extends Employee{

    private String speciality;

    @Override
    public String toString() {
        return "Engineer{ name = " + getName() + ", salary= " + getSalary() + ", speciality= " + speciality;
    }
}
