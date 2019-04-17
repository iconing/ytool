package inheritance;

public class Sub2 extends Object{
    private static final Sub2 inst = new Sub2();

    private Sub2() {
    }

    public static Sub2 getInstance() {
        return inst;
    }

    public void log() {
    }

    public static void main(String[] args) {
        new Sub2().log();
    }
}
