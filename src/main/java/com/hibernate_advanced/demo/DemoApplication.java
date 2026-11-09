package com.hibernate_advanced.demo;

import com.hibernate_advanced.demo.dao.AppDao;
import com.hibernate_advanced.demo.entity.Instructor;
import com.hibernate_advanced.demo.entity.InstructorDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppDao appDao) {
		return args -> {
			// createInstructor(appDao);
			// findInstructor(appDao);
			// deleteInstructor(appDao);
			// findInstructorDetail(appDao);
			// deleteInstructorDetail(appDao);
		};
	}

	private void createInstructor(AppDao appDao) {
		Instructor instructor = new Instructor("Vicky", "Magtanggol", "vicky.mags@example.com");
		InstructorDetail instructorDetail = new InstructorDetail("Math", "Solving problems");
		instructor.setInstructorDetail(instructorDetail);
		appDao.save(instructor);
		System.out.println("Information saved!");
	}

	private void findInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Find id: " + id);
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		if (instructor != null) {
			System.out.println("Details: " + instructor.getInstructorDetail());
		}
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Delete id: " + id);
		appDao.deleteInstructorById(id);
		System.out.println("Deleted successfully!");
	}

	private void findInstructorDetail(AppDao appDao) {
		int id = 23;
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
		if (instructorDetail == null) {
			System.out.println("No instructor detail found with id " + id);
			return;
		}

		System.out.println("Details: " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id = 21;
		System.out.println("Delete id: " + id);
		appDao.deleteInstructorDetail(id);
		System.out.println("Deleted successfully!");
	}

}
