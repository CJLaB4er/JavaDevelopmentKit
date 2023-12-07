package generics;

import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {
        semTask1();

    }

    public static void semTask1() {
        String t = " ";
        DataInputStream v = new DataInputStream(System.in);
        Number k = 5;
        MegaClass<Comparable, DataInputStream, Number> mgc = new MegaClass<>(t, v, k);
        mgc.pringAllClass();


    }
}
