package inheritance;

public class Sup implements Cloneable {
    private String fileName;
    public static Sup INST= null;

    protected void log() {
        System.out.println(fileName);
    }

    Sup() {
        fileName = "111111111";
    }

    synchronized public static Sup getInstance() {
        if (INST == null) {
            INST = new Sup();
        }
        return INST;
    }

    private void printF() {
        fileName = "bbbbb" + 1 ;
    }

    @Override
    public Sup clone() throws CloneNotSupportedException {
        return (Sup) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Sup s1 = new Sup();
        System.out.println(s1.fileName);
        Sup s2 = s1.clone();
        s2.fileName = "3233333";
        System.out.println(s2.fileName);
        System.out.println(s1.fileName);

        String addd = "    ksdfkjsdkfj          "
                + "akdfj";
        System.out.println(addd.replaceAll("\\s*|\t|\r|\n", ""));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               Sup inst = getInstance();
                System.out.println("111111------:" + inst.fileName);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("111111------:" + inst.fileName);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Sup inst = getInstance();
                inst.printF();
                System.out.println("2222222:------:" + inst.fileName);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("222222-------:" + inst.fileName);
            }
        });

        t1.start();
        t2.start();
    }
}
