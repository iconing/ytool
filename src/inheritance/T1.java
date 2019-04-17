package inheritance;

public class T1 {
    private String name;

    public T1() {
        this.name = "T10----SUPER";
    }

    String getName() {
        return name;
    }

    public void run(String name) {
        this.name = name;
        System.out.println("run里的的--->  " + name);
    }

    public static void main(String[] args) {

        long a = 23;
        System.out.println((int) a);
        Thread t1 = new Thread(() -> {
            T2 inst = T2.getInstance();
            inst.run("线程1----------");
            System.out.println("线程11111:" + inst.getName());
        });

        Thread t2 = new Thread(() -> {
            T2 inst = T2.getInstance();
            inst.run("线程2----------");
            System.out.println("线程22222:" + inst.getName());
        });

        t1.start();
        t2.start();

        new T1().run("super");


    }
}





