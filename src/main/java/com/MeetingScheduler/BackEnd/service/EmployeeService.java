/**
 * 
 */
package com.MeetingScheduler.BackEnd.service;

import java.util.List;
import com.MeetingScheduler.BackEnd.model.Employee;
import org.springframework.stereotype.Service;
/**
 * @author SURITH
 *
 */
@Service
public interface EmployeeService {
	
	void createEmployee(Employee employee);

	void deleteEmployee(int id);

	Employee getEmployee(int id);

	List<Employee> getAllEmployee();

}
