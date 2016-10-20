/**
 * 
 */
package com.MeetingScheduler.BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MeetingScheduler.BackEnd.model.Meeting;
import com.MeetingScheduler.BackEnd.repository.MeetingRepository;

/**
 * @author SURITH
 *
 */
@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Override
	public void createMeeting(Meeting meeting) {
		meetingRepository.save(meeting);
		
	}

	@Override
	public void deleteMeeting(int id) {
		meetingRepository.delete(id);
		
	}

	@Override
	public Meeting getMeeting(int id) {
		return meetingRepository.findOne(id);
	}

	@Override
	public List<Meeting> getAllMeetings() {
		return (List<Meeting>) meetingRepository.findAll();
	}

	@Override
	public String updateMeeting(Meeting meeting) {
		Meeting data;
		try {
			data = meetingRepository.findOne(meeting.getmId());
			data.setStartTime(meeting.getStartTime());
			data.setEndTime(meeting.getEndTime());
			data.setmName(meeting.getmName());
			//data.setAttendants(meeting.getAttendants());
			return meetingRepository.save(data).getmName();
        } catch (Exception e) {
            return e.getMessage();
        }
		
	}

}
