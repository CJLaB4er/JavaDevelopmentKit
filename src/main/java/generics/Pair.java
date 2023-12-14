package generics;

public class Pair<T, U> {
	private final T valueT;
	private final U valueU;

	public Pair(T valueT, U valueU) {
		this.valueT = valueT;
		this.valueU = valueU;
	}

	public T getValueT() {
		return valueT;
	}

	public U getValueU() {
		return valueU;
	}

	@Override
	public String toString() {
		return "Pair{" +
				"valueT=" + valueT +
				", valueU=" + valueU +
				'}';
	}
}
