/**
 * 
 */
package com.MeetingScheduler.BackEnd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MeetingScheduler.BackEnd.model.Meeting;

/**
 * @author SURITH
 *
 */
@Service
public interface MeetingService {

	void createMeeting(Meeting meeting);

	void deleteMeeting(int id);

	Meeting getMeeting(int id);

	List<Meeting> getAllMeetings();

	String updateMeeting(Meeting meeting);

}
