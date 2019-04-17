package inheritance;

public class T2 extends T1{
    private static final T2 inst = new T2();

    private T2() {}

    public static T2 getInstance() {
        return inst;
    }
}