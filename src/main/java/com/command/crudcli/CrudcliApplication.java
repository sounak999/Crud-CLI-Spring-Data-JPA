package com.command.crudcli;

import com.command.crudcli.dao.StudentDAO;
import com.command.crudcli.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudcliApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudcliApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			findAllStudentsByLastName(studentDAO);
		};
	}

	private void findAllStudentsByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Duck");

		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		System.out.println("List of all the registered students:- \n");

		for (Student student: studentDAO.findAll()) {
			System.out.println(student);
		}
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

	private void readStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating a new student object...");
		Student student = new Student("Daffy", "Duck", "daffy@microsoft.com");

		// save the student
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());

		// retrieve student
		Student retrivedStudent = studentDAO.findById(1);
		System.out.println(retrivedStudent.toString());
	}

}
