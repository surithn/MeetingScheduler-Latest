/**
 * 
 */
package com.MeetingScheduler.BackEnd.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
/**
 * @author SURITH
 *
 */
@Entity
@Table(name = "attendants")
public class Attendants {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Meeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="a_id")
    private int id;
    @Column(name="a_name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "attendants")
    private List<Meeting> meetings;
}
