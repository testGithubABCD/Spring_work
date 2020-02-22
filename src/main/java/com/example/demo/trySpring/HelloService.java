package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;

	public Employee findOne(int id) {
		Map<String, Object> map = helloRepository.findOne(id);
		int employeeId = (Integer) map.get("id");
		String name = (String) map.get("name");
		int age = (Integer) map.get("age");

		Employee employee = new Employee();

		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setAge(age);
		return employee;

	}

}
