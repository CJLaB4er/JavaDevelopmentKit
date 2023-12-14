package generics.lecture;

public class Main {
	public static void main(String[] args) {
		Box b1 = new Box(20);
		Box b2 = new Box(30);
		System.out.println((Integer) b1.getObj() + (Integer) b2.getObj());

		Box b3 = new Box("Hello ");
		Box b4 = new Box("World!");
		System.out.println((String) b3.getObj() + (String) b4.getObj());

		GBox<String> stringGBox = new GBox<>("Hello!");
		stringGBox.showType();
		GBox<Integer> integerGBox = new GBox<>(12);
		integerGBox.showType();

		KVBox<Integer, String> kvb0 = new KVBox<>(1, "Hello!");
		KVBox<String, GBox<String>> kvb1 = new KVBox<>("World", new GBox<>("Java"));
		kvb0.showType();
		kvb1.showType();

		GBox<Integer> box = new GBox<>(null);
		setIfNull(box, 13);
		System.out.println(box.getValue());
		GBox<Integer> box0 = new GBox<>(1);
		setIfNull(box, 13);
		System.out.println(box0.getValue());
	}

	private static class Box {
		private Object obj;

		public Box(Object obj) {
			this.obj = obj;
		}

		public void setObj(Object obj) {
			this.obj = obj;
		}

		public Object getObj() {
			return obj;
		}

		public void printInfo() {
			System.out.printf("Box (%s): %s\n",
					obj.getClass().getSimpleName(),
					obj.toString());
		}
	}

	private static class GBox<T> {
		private T value;

		public GBox(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public void showType() {
			System.out.printf("Type is %s, with value %s\n",
					value.getClass().getName(), getValue());
		}
	}

	private static class KVBox<K, V> {
		private K key;
		private V value;

		public KVBox(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void showType() {
			System.out.printf("Type of key is %s, key = %s," +
							"type of value is %s, value = %s\n",
					key.getClass().getName(), getKey(),
					value.getClass().getName(), getValue());
		}
	}

	private static class BBox<V extends Number> {
		private V value;

		public BBox(V value) {
			this.value = value;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

	private static <T> void setIfNull(GBox<T> box, T t) {
		if (box.getValue() == null) {
			box.setValue(t);
		}
	}

}
