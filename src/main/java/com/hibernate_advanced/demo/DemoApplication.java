package com.hibernate_advanced.demo;

import com.hibernate_advanced.demo.dao.AppDao;
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
			appDao.populateExampleData();
			findInstructorDetail(appDao);
		};
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

}
