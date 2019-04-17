public class TestString {

    public static void main(String[] args) {
        /**
        String tranFmt = "";
        long start = System.currentTimeMillis();
        for(int i=0; i<10000000; i++) {
            tranFmt = "<aaaa><Document><SndBrhNb>402701002999</SndBrhNb>";
            if(tranFmt != null && tranFmt.contains("<aaaa>")){
                tranFmt = tranFmt.substring("<aaaa>".length() - 1);
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for(int i=0; i<10000000; i++) {
            tranFmt = "<aaaa><Document><SndBrhNb>402701002999</SndBrhNb>";
            if(tranFmt != null){
                tranFmt = tranFmt.replace("<aaaa>", "");
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
         */

        Aaaaa a = new Aaaaa();
        a.save();

    }

    void save() {
        printa();
    }

    void printa() {
        System.out.println("我是父类的方法");
    }


}

class Aaaaa extends TestString {

    void printa() {
        System.out.println("我是子类的方法");
    }
}
