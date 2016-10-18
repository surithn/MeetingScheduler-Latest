/**
 * 
 */
package com.MeetingScheduler.BackEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SURITH
 *
 */
@Controller
public class AppController {

	@RequestMapping("/MeetingSchduler")
	public String meetingSchduler() {
		return "index";
	}
	
	@RequestMapping("/meetings_html")
	public String meetingsHtml() {
		return "meetings";
	}
	
	@RequestMapping("/meeting-view_html")
	public String meetingsViewHtml() {
		return "meeting-view";
	}
	
	@RequestMapping("/meetings-add_html")
	public String meetingsAddHtml() {
		return "meetings-add";
	}
	
	@RequestMapping("/meetings-edit_html")
	public String meetingsEditHtml() {
		return "meetings-edit";
	}
	
	@RequestMapping("/_form_html")
	public String formHtml() {
		return "_form";
	}
}
