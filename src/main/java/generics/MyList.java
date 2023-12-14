package generics;

import java.util.Iterator;

public class MyList<E> implements Iterable<E>{
	private E[] array;
	private final Object[] intitialArray = {};
	private int size;
	private int index;

	public MyList(E[] array) {
		this.array = array;
		size = array.length;
	}

	public MyList() {
		this.array = (E[]) intitialArray;
		size = 0;
	}

	public <T extends E> void addElement(T element) {
		if (size == array.length) {
			Object[] newArray = new Object[(int) (array.length * 1.5) + 1];
			System.arraycopy(array, 0, newArray, 0, array.length);
			newArray[size] = element;
			array = (E[]) newArray;
		} else {
			array[size] = element;
		}
		size++;
	}

	public void printList() {
		System.out.println("Кол-во непустых элементов: " + size);
		System.out.println("Длина массива: " + array.length);
		for (E element :
				array) {
			System.out.println(element);
		}
	}

	public void removeElement(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		array[size - 1] = null;
		size--;
	}

	public int getSize() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyListIterator();
	}

	class MyListIterator implements Iterator<E> {
		int index;


		public MyListIterator() {
			this.index = 0;


		}

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public E next() {
			return array[index++];
		}
	}
}
