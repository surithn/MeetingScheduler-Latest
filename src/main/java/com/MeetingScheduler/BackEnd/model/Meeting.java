package com.MeetingScheduler.BackEnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "meeting")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="mId")
public class Meeting {

	public List<Attendants> getAttendants() {
		return attendants;
	}

	public void setAttendants(List<Attendants> attendants) {
		this.attendants = attendants;
	}

	public String getmRoom() {
		return mRoom;
	}

	public void setmRoom(String mRoom) {
		this.mRoom = mRoom;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "m_id")
	private int mId;
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "end_time")
	private String endTime;
	@Column(name = "m_name")
	private String mName;
	@Column(name = "m_room")
	private String mRoom;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "met_att_junction", joinColumns = {
			@JoinColumn(name = "m_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "a_id",
					nullable = false, updatable = false) })
	private List<Attendants> attendants;

	@Override
	public String toString() {
		return String.format("Meeting[mId=%d, startTime='%s', endTime='%s']",
				mId, startTime, endTime);
	}

}
