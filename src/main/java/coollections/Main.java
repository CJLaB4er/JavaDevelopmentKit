package coollections;

import java.time.LocalDate;
import java.util.*;

public class Main {
	public static void main(String[] args) {
//		task1();
//		task2();
//		task3();
		homeWork();
	}

	private static void task1() {
		/*
		 * - Создайте коллекцию мужских и женских имен с помощью интерфейса List
		 * - Отсортируйте коллекцию в алфавитном порядке
		 * - Отсортируйте коллекцию по количеству букв в слове
		 * - Разверните коллекцию
		 */


//		Создание и добавление элементов в список
		List<String> names = new ArrayList<>();
		names.add("Александр");
		names.add("Маша");
		names.add("Николай");
		names.add("Елена");
		names.add("Олег");
		System.out.println(names);

//		Сортировка списка в алфавитном порядке (метод по умолчанию)
		Collections.sort(names);
		System.out.println(names);

//		Сортировка по кол-ву букв в слове
		names.sort(Comparator.comparingInt(String::length));
		System.out.println(names);

//		Разворот значений внутри списка
		Collections.reverse(names);
		System.out.println(names);

	}

	private static void task2() {
		/*
		 * Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
		 * Получите уникальный список Set на основании List
		 * Определите наименьший элемент (алфавитный порядок)
		 * Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
		 * Удалите все элементы содержащие букву ‘A’
		 */

		List<String> names = new ArrayList<>();
		names.add("Александр");
		names.add("Александр");
		names.add("Маша");
		names.add("Маша");
		names.add("Николай");
		names.add("Николай");
		names.add("Елена");
		names.add("Елена");
		names.add("Олег");
		names.add("Олег");
		System.out.println(names);

		Set<String> setNames = new HashSet<>(names);
		System.out.println(setNames);


		System.out.println(Collections.min(setNames));
		System.out.println(setNames.stream().sorted().toList().get(0));

		String maxName = setNames.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println(maxName);

		System.out.println(new StringBuilder(maxName).reverse());

		setNames.removeIf(name -> name.toLowerCase().contains("а"));

		Iterator<String> iter = setNames.iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			if (name.toLowerCase().contains("а")) iter.remove();
		}

		System.out.println(setNames);
	}

	private static void task3() {
		/*
		 * Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
		 * Найдите человека с самым маленьким номером телефона
		 * Найдите номер телефона человека чье имя самое большое в алфавитном порядке
		 */

		Map<String, String> phoneBook = new HashMap<>();
		phoneBook.put("1244213453", "Ivan");
		phoneBook.put("1244213112", "Oleg");
		phoneBook.put("1231234232", "Igor");
		phoneBook.put("2431234232", "Olga");

		String minkey = phoneBook
				.keySet()
				.stream()
				.sorted()
				.findFirst()
				.get();
		System.out.println("Пользователь с наименьшим номером - "
				+ phoneBook.get(minkey)
				+ " : "
				+ minkey);

		String maxValue = phoneBook
				.values()
				.stream()
				.sorted((s1, s2) -> -s1.compareTo(s2))
				.findFirst()
				.get();

		System.out.println("Пользователь с наибольшим именем - "
				+ maxValue
				+ " : "
				+ phoneBook
				.entrySet()
				.stream()
				.filter((e) -> e.getValue().equals(maxValue))
				.findAny()
				.get()
				.getKey());
	}

	private static void homeWork() {
		EmployeeDirectory employees = new EmployeeDirectory();

		employees.add(new Employee("146548", "Ivan", LocalDate.of(2021, 1, 1)));
		employees.add(new Employee("123414", "Ivan", LocalDate.of(2020, 3, 14)));
		employees.add(new Employee("123145", "Oleg", LocalDate.of(2014, 7, 14)));
		employees.add(new Employee("352513", "Viktor"));
		employees.add(new Employee("111333", "Oleg"));


		System.out.println("Поиск сотрудников по имени");
		employees.searchForName("Ivan");

		System.out.println("Поиск сотрудников по стажу, не мнее полных лет");
		employees.searchForExperience(3);

		System.out.println("Поиск номера телефона по имени сотрудника");
		employees.phoneNumberForName("Oleg");

		System.out.println("Поиск сотрудника по id");
		employees.idSearch(3);

	}
}
