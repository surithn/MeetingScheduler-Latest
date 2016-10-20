/**
 * 
 */
package com.MeetingScheduler.BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MeetingScheduler.BackEnd.model.Rooms;
import com.MeetingScheduler.BackEnd.repository.RoomsRepository;

/**
 * @author SURITH
 *
 */
@Service
@Transactional
public class RoomsServiceImpl {
	
	@Autowired
	private RoomsRepository roomsRepository;
	
	public List<Rooms> getAllRooms() {
		return (List<Rooms>) roomsRepository.findAll();
	}

}
