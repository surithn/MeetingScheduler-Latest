/**
 * 
 */
package com.MeetingScheduler.BackEnd.controller;

/**
 * @author SURITH
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MeetingScheduler.BackEnd.model.Employee;
import com.MeetingScheduler.BackEnd.model.Rooms;
import com.MeetingScheduler.BackEnd.service.EmployeeService;
import com.MeetingScheduler.BackEnd.service.RoomsServiceImpl;

@RestController
public class OtherServiceController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoomsServiceImpl roomsServiceImpl;
	
	@RequestMapping(value ="/MeetingSchduler/others/emp", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@RequestMapping(value ="/MeetingSchduler/others/room", method = RequestMethod.GET)
	public @ResponseBody List<Rooms> getRooms(){
		return roomsServiceImpl.getAllRooms();
	}
}
