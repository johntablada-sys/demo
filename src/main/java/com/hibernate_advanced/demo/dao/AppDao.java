package com.hibernate_advanced.demo.dao;

import com.hibernate_advanced.demo.entity.Instructor;
import com.hibernate_advanced.demo.entity.InstructorDetail;

public interface AppDao {

	void save(Instructor instructor);

	Instructor findInstructorById(int id);

	void deleteInstructorById(int id);

	InstructorDetail findInstructorDetailById(int id);

	void populateExampleData();

	void deleteInstructorDetail(int id);
}
