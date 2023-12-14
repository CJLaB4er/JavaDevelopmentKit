package generics;

import java.io.DataInputStream;

/*
Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
возможность хранить любые типы данных, иметь методы добавления и удаления элементов.

Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям любого типа,
содержащим любые типы данных. Итераторы обычно имеют только два метода – проверка на наличие следующего
элемента и переход к следующему элементу. Но также, особенно в других языках программирования, возможно встретить
итераторы, реализующие дополнительную логику.
 */
public class Main {
	public static void main(String[] args) {
//		semTask1();
//		semTask2v1();
//		semtask2v2();
//		semtask3();

		hWCalc();

		Integer[] a = new Integer[]{5, 6, 7, 8};
		Integer[] b = new Integer[]{5, 6, 7, 88};
		System.out.println(compareArrays(a, b));
		b[b.length - 1] = 8;
		System.out.println(compareArrays(a, b));

		Pair<String, Integer> pair = new Pair<>("Hello", 100);
		System.out.println(pair);

	}

	public static void semTask1() {
		String t = " ";
		DataInputStream v = new DataInputStream(System.in);
		Number k = 5;
		MegaClass<Comparable, DataInputStream, Number> mgc = new MegaClass<>(t, v, k);
		mgc.pringAllClass();
	}

	public static void semTask2v1() {
		Number[] numArr = new Number[3];
		numArr[0] = 1;
		numArr[1] = 2.0f;
		numArr[2] = 1412412L;
		MyList<Number> myList = new MyList<>(numArr);
		myList.printList();
		myList.addElement(5);
		myList.printList();
		myList.removeElement(1);
		myList.printList();
	}

	public static void semtask2v2() {
		MyList<Number> myList = new MyList<>();
		myList.printList();
		myList.addElement(1);
		myList.addElement(2.0f);
		myList.addElement(1412412L);
		myList.printList();
		myList.removeElement(1);
		myList.printList();
	}

	public static void semtask3() {
		MyList<Number> myList = new MyList<>();
		myList.addElement(1);
		myList.addElement(2.0f);
		myList.addElement(1412412L);
		for (Number numb : myList) {
			System.out.println(numb);

		}
	}

	public static void hWCalc() {
		System.out.println(Calc.sum(-1, 1.5));
		System.out.println(Calc.substract(22, 1f));
		System.out.println(Calc.multiply(3, Calc.divide(1, 3)));
		System.out.println(Calc.divide(-1, 0));
		System.out.println(Calc.divide(0, 0));

	}

	private static <T> boolean compareArrays(T[] arr1, T[] arr2) {
		if (arr1.length != arr2.length) return false;
		for (int i = 0; i < arr1.length; i++) {
			if (!(arr1[i].equals(arr2[i]))) return false;
		}
		return true;
	}
}
