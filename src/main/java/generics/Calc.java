package generics;

public class Calc {
	public static <T extends Number, U extends Number> double sum(T numb1, U numb2) {
		return numb1.doubleValue() + numb2.doubleValue();
	}

	public static <T extends Number, U extends Number> double substract(T numb1, U numb2) {
		return numb1.doubleValue() - numb2.doubleValue();
	}

	public static <T extends Number, U extends Number> double multiply(T numb1, U numb2) {
		return numb1.doubleValue() * numb2.doubleValue();
	}

	public static <T extends Number, U extends Number> double divide(T numb1, U numb2) {
		return numb1.doubleValue() / numb2.doubleValue();
	}
}
