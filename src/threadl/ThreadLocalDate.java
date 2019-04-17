package threadl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDate {
    private static ThreadLocal<DateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse(String dateStr) throws ParseException {
        return dateFormat.get().parse(dateStr);
    }

    public static String format(Date date) {
        return dateFormat.get().format(date);
    }
}
