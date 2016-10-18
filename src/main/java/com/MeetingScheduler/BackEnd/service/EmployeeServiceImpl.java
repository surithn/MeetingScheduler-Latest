/**
 * 
 */
package com.MeetingScheduler.BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MeetingScheduler.BackEnd.model.Employee;
import com.MeetingScheduler.BackEnd.repository.EmployeeRepository;

/**
 * @author SURITH
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public void createEmployee(Employee employee) {
		employeerepository.save(employee);

	}

	@Override
	public void deleteEmployee(int id) {
		employeerepository.delete(id);

	}

	@Override
	public Employee getEmployee(int id) {
		return employeerepository.findOne(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeerepository.findAll();
	}

}
