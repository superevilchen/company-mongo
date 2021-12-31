package com.example.company.beans;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Secretary extends Employee{

    private String office;

    @Override
    public String toString() {
        return "Secretary{ name = " + getName() + ", salary= " + getSalary() + ", office= " + office;
    }
}
