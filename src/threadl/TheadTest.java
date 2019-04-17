package threadl;

public class TheadTest {
    static String ab = "111111111111111";

    static void printAB(String threadName) {
        System.out.println(threadName + ":" + ab);
    }

    static void printAB() {
        System.out.println(ab);
    }
    void m1(int a) throws InterruptedException {
        ab = "aaaaaaaaaaaaaaaa";
        Thread.sleep(10);
    }

    void m2() throws InterruptedException {
        ab = "bbbbbbbbbbbbbbbb";
        Thread.sleep(10);
    }

    public static void main(String[] args) throws InterruptedException {

        TheadTest t = new TheadTest();

        for (int i = 0; i < 5; i++) {
                Thread t1 = new Thread(() -> {
                    try {
                        t.m1(1);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                t1.setName("t1");
                t1.run();
            printAB();

                Thread t3 = new Thread(() -> {
                });
                t3.setName("----------------t3");
                t3.run();
                printAB();
                Thread t2 = new Thread(() -> {
                    try {
                        t.m2();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                t2.setName("t2");
                t2.run();
//                Thread.sleep(500);
                printAB();


        }
    }
}
