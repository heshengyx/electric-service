package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Employee;
import com.grgbanking.electric.service.IEmployeeService;
import com.grgbanking.electric.param.EmployeeQueryParam;

public class EmployeeJunitTest extends BaseJunitTest {

	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	public void testSaveBatch() {
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 10; i < 50; i++) {
			Employee employee = new Employee();
			employees.add(employee);
		}
		employeeService.saveBatch(employees);
	}
	
	@Test
	public void testQueryAll() {
		EmployeeQueryParam param = new EmployeeQueryParam();
		List<Employee> employees = employeeService.queryAll(param);
		for (Employee employee : employees) {
			System.out.println(employee.getId());
		}
	}
}
