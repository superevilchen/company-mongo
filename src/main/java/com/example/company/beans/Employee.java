package com.example.company.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class Employee {

    @Id
    private String id;

    private String name;
    private double salary;
}
