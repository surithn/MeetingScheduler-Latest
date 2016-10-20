package com.MeetingScheduler.BackEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "employee")
public class Employee {

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

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="e_id")
    private int id;
    @Column(name="e_name")
    private String name;

    @Override
    public String toString() {
        return String.format("Employee[id=%d, name='%s']", id, name);
    }

}
