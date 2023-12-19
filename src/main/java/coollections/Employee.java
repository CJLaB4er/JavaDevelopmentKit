package coollections;
/*
 * - каждый сотрудник должен иметь следующие атрибуты:
 * ○ Табельный номер
 * ○ Номер телефона
 * ○ Имя
 * ○ Стаж
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Employee {
	private static int countId; // общая переменная со счётчиком id для всех сотрудников
	private final int id;
	private String phoneNumber, Name;
	private final LocalDate hireDate;

	public Employee(String phoneNumber, String name) {
		this.id = ++countId; // устанавливаем сотруднику следующий свободный id
		this.phoneNumber = phoneNumber;
		Name = name;
		this.hireDate = LocalDate.now(); // устанавливаем текущую дату, как дату начала работы
	}

	public Employee(String phoneNumber, String name, LocalDate hireDate) {
		this.id = ++countId;
		this.phoneNumber = phoneNumber;
		Name = name;
		this.hireDate = hireDate;
	}

	public int getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getName() {
		return Name;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	// Метод возвращает количество полных лет трудового стажа
	public int getExperience() {
		return Period.between(hireDate, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return "{id=" + id +
				", name=" + Name +
				", phoneNumber=" + phoneNumber +
				", трудовой стаж, полных лет=" + getExperience() +
				'}';
	}
}
