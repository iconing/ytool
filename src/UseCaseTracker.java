import com.sun.security.auth.NTNumericCredential;

import javax.naming.NameNotFoundException;
import java.lang.reflect.Method;
import java.util.*;

public class UseCaseTracker {

    public static void trackUseCase(List<Integer> idList, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("found use case:" + uc.id() + " " + uc.description());
//                idList.remove(new Integer(uc.id()));
                idList.remove(uc.id());
            }
        }

        for (Integer i : idList) {
            System.out.println("warning: miss use case" + i);
        }
    }

    public static void main(String[] args) {
//        Objects.equals("aa", "aa");
//        List<Integer> idList = new LinkedList<>();
//        Collections.addAll(idList, 1, 2, 3, 4);
//        trackUseCase(idList, TestUseCase.java);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        // for (String s : list) {
        //     if (s.equals("a")) {
        //         list.remove(s);
        //     }
        // }
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            if(s.equals("a")){
                list.remove(s);
            }
        }

        // for (int o = 0; o < list.size(); o++) {
        //         if (list.get(o).equals("a")) {
        //             list.remove(o);
        //         }
        // }

        System.out.println(list);
    }
}
