package com.command.crudcli;

import com.command.crudcli.dao.StudentDAO;
import com.command.crudcli.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudcliApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudcliApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating a new student object...");
		Student student = new Student("Sounak", "Saha", "sounak.saha@google.com");

		// save the student
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

}
