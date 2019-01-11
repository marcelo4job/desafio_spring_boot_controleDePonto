package com.pontocontrole;

import com.pontocontrole.domain.Employee;
import com.pontocontrole.domain.RecordTime;
import com.pontocontrole.repositories.EmployeeRepository;
import com.pontocontrole.repositories.RecordTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static java.util.Arrays.asList;

@SpringBootApplication
public class PontocontroApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PontocontroApplication.class, args);
	}

	public LocalTime time = LocalTime.now();
	public LocalDate date = LocalDate.now();

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RecordTimeRepository recordTimeRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee1 = new Employee(null, "Marcelo", "123456", "Analista", "Desenvolvimento");

		RecordTime rec1 = new RecordTime(null,time,date, 1, 1, employee1 );

		employee1.getRecords().removeAll(Arrays.asList(rec1));

		employeeRepository.saveAll(asList(employee1));
		recordTimeRepository.saveAll(asList(rec1));

	}

}

