package com.MeetingScheduler.BackEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "rooms")
public class Rooms {

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="r_id")
    private int rId;
    @Column(name="r_name")
    private String rName;
    
    @Override
    public String toString() {
        return String.format("Rooms[id=%d, name='%s']", rId, rName);
    }

}
