package coollections;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
 * ● Добавить метод, который ищет сотрудника по стажу (может быть список)
 * ● Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
 * ● Добавить метод, который ищет сотрудника по табельному номеру
 * ● Добавить метод добавление нового сотрудника в справочник
 */
public class EmployeeDirectory {
	List<Employee> employees = new ArrayList<>();

	public void add(Employee emp) {
		employees.add(emp);
	}

	// Метод ищет сотрудников по имени, и выводит о них полную информацию
	public void searchForName(String name) {
		employees.stream()
				.filter(employee -> employee.getName().equals(name))
				.forEach(System.out::println);
	}

	// Метод ищет сотрудников со стажем не менее указанного
	public void searchForExperience(int exp) {
		employees.stream()
				.filter(employee -> employee.getExperience() >= exp)
				.forEach(System.out::println);
	}

	public void phoneNumberForName(String name) {
		employees.stream()
				.filter(employee -> employee.getName().equals(name))
				.forEach(EmployeeDirectory::namePhone);
	}

	private static void namePhone(Employee employee) {
		System.out.println(employee.getName() + " - " + employee.getPhoneNumber());
	}

	public void idSearch(int id) {
		for (Employee emp : employees) {
			if(emp.getId() == id)
				System.out.println(emp);
		}
	}

}
