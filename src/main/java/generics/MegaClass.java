package generics;

import java.io.DataInput;
import java.io.InputStream;

/*
Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа (T, V, K), конструктор,
принимающий на вход параметры типа (T, V, K), методы
возвращающие значения трех переменных. Создать метод, выводящий на консоль имена классов для трех переменных класса.
Наложить ограничения на параметры типа: T должен реализовать интерфейс Comparable (классы оболочки, String),
V должен реализовать интерфейс DataInput и расширять класс InputStream, K должен расширять класс Number
 */
public class MegaClass<T extends Comparable, V extends InputStream & DataInput, K extends Number> {
    public T t;
    public V v;
    public K k;

    public MegaClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setV(V v) {
        this.v = v;
    }

    public void setK(K k) {
        this.k = k;
    }
    public void pringAllClass(){
        System.out.println(t.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
        System.out.println(k.getClass().getSimpleName());
    }
}
