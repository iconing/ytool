package db;

import java.util.HashMap;
import java.util.Map;

public class Mysql {
    public static final String e = "2454";
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.forEach(Mysql::method);
    }

    private static void method(String a1, String a2) {
        System.out.println(a1 + ":" + a2);
    }

}
