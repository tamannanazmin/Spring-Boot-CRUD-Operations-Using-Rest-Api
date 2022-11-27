package com.example.learning;

import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class LearningApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}
	@Autowired
	private SubjectRepository subjectRepository;
	@Override
	public void run(String... args) throws Exception {
		Subject subject1 = new Subject();
		subject1.setEmail("tamanna.naz98@gmail.com");
		subject1.setName("Tamanna");

	}
}
