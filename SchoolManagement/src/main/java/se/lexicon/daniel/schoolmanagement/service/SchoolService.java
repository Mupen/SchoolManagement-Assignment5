package se.lexicon.daniel.schoolmanagement.service;

import java.time.LocalDate;
import java.util.List;

	public interface SchoolService {

		SalesPerson registerNewSalesPerson(String name, LocalDate hiringDate);

		SystemDeveloper registerNewSystemDeveloper(String name, LocalDate hiringDate);

		SystemDeveloper registerNewSystemDeveloper(String name, LocalDate hiringDate, String[] certificates,
				String[] languages);

		boolean removeEmployee(Employee employee);

		Employee findEmployeeById(int id);

		List<Employee> findByName(String name);

		List<Employee> findBySalaryAbove(double salary);

		List<Employee> findBySalaryBelow(double salary);

		List<SystemDeveloper> findAllSystemDevs();

		List<SalesPerson> findAllSalesPersons();

		List<Employee> getAllEmployees();

	}