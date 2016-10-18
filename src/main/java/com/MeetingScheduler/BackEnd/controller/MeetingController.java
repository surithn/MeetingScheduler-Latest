/**
 * 
 */
package com.MeetingScheduler.BackEnd.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.MeetingScheduler.BackEnd.model.Meeting;
import com.MeetingScheduler.BackEnd.service.MeetingService;

/**
 * @author SURITH
 *
 */
@RestController
@RequestMapping(value ="/MeetingSchduler/meeting")
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Meeting getMeeting(@PathVariable("id") int id) {
		return meetingService.getMeeting(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Meeting> getMeetings(){
		return meetingService.getAllMeetings();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteMeeting(@PathVariable("id") int id){
		meetingService.deleteMeeting(id);
	}

/*	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteExpired(){
		List<Meeting> meetings = meetingService.getAllMeetings();
		Date date = new Date();
		for (Meeting meeting : meetings) {
			if (date.after(meeting.getEnd())) {
				meetingService.deleteMeeting(meeting.getId());
			}
		}
	}*/

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void createMeeting(@RequestBody Meeting meeting){
		meetingService.createMeeting(meeting);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateMeeting(@RequestBody Meeting meeting){
		meetingService.updateMeeting(meeting);
	}
}
