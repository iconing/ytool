public class lambda {
    public void p() {
        System.out.println("lambda");
    }

}

abstract class Abs1 extends  lambda{
    public final void b(){
        System.out.println("final b");
    }

    public static void main(String[] args) {
        lambda s = new Imp1();
        s.p();
    }
}

class Imp1 extends Abs1{
    @Override
    public void p() {
        super.b();
        System.out.println("Imp1");
    }
}
