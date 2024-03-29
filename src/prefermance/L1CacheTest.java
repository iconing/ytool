package prefermance;

public class L1CacheTest {
    private final int ARR_SIZE = 1 * 1024 * 1024;
    private final int[] arr = new int[ARR_SIZE];

    private void doLoop2() {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }

    private void doLoop1() {
        for (int i = 0; i < arr.length; i += 16) {
            arr[i]++;
        }
    }

    private void run() {
        for (int i = 0; i < 10000; i++) {
            doLoop1();
            doLoop2();
        }

        for (int i = 0; i < 100; i++) {
            long t0 = System.nanoTime();
            doLoop1();
            long t1 = System.nanoTime();
            doLoop2();
            long t2 = System.nanoTime();

            long e1 = t1 - t0;
            long e2 = t2 - t1;
            System.out.println("loop1: " + e1 + " nanos ==== " + "loop2: " + e2 + " nanos");
        }
    }

    public static void main(String[] args) {
        L1CacheTest lt = new L1CacheTest();
        lt.run();
    }
}
