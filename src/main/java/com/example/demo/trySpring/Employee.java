package com.example.demo.trySpring;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Employee {
	private int employeeId;
	private String employeeName;
	private int age;
}
