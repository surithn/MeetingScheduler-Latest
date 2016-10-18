package com.MeetingScheduler.BackEnd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.MeetingScheduler.BackEnd.model.Meeting;


@RepositoryRestResource
public interface MeetingRepository extends CrudRepository<Meeting, Integer>{
}
