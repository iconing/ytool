import threadl.ThreadLocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Testaa {
    public static String getExpStr() {
        return "dfksdflslf";
    }

    public static void main(String[] args) throws ParseException {
        String s7 = "123456";
        System.out.println(s7.substring(0, s7.length()));

        LocalDate now1 = LocalDate.now();
        LocalDate now2 = LocalDate.now();

        System.out.println(now1);
        System.out.println(now1.equals(now2));
        LocalDateTime parse = LocalDateTime.parse("2019/02/17 09:34:51", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("parse:" + parse);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now:" + now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));

        System.out.println(" -----" + DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now()));

        int a_ = 11_999_000;

        String s = "000111";
        System.out.println('1' == s.charAt(3));

        System.out.println(0 + 'b');


        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'hh-mm-ss").format(new Date()));
        double d = 3;

        StringBuilder sb1 = new StringBuilder();
        addAmtNumber(sb1, d);
        System.out.println(sb1);


        System.out.println(ThreadLocalDate.parse("2018-09-22 01:23:44").getTime());
        Point[] ps = new Point[]{new Point(1, 2), new Point(3, 4), new Point(5, 6)};
        for (Point p : ps) {
            p.setX(10);
            p.setY(20);
        }
        System.out.println(Arrays.toString(ps));


        String s1 = "2";
        String s2 = "3";
        String s3 = "4";

        s1 += "1111" + s3;
        System.out.println(s1);

        ArrayList<String> a = new ArrayList<>();
        a.add("20180203");
        a.add("20180204");
        a.add("20180205");

        System.out.println(a.stream().collect(Collectors.joining(", ")));
        StringBuilder sb = new StringBuilder("('");
        sb.append(a.stream()
                .collect(Collectors.joining("', '")))
                .append("')");
        System.out.println(sb.toString());

        int b = a.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();

        System.out.println(b == 20180203);

        int ccc = 0;
        System.out.println(ccc++ > 0);
        // int a = 2;
        // int b = 4;
        // a ^= b;
        // System.out.println(a);
        //
        // b = a ^ b;
        // System.out.println(b);
        //
        // a ^= b;
        // System.out.println(a);


    }
    private static void addAmtNumber(StringBuilder sb, Double amt) {
        sb.append("CNY").append(String.format("%.2f", amt)).append("|");
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "x:" + x + "\ty:" + y + "";
        }
    }


}
