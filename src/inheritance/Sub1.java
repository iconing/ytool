package inheritance;

import sun.security.jca.GetInstance;

public class Sub1 extends Sup{
    private static final Sub1 inst = new Sub1();

    private Sub1() {
    }

    public static Sub1 getInstance() {
        return inst;
    }

    public void log() {
    }

    public static void main(String[] args) {
        new Sub1().log();
    }
}
