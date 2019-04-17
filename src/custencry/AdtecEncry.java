package custencry;

import com.adtec.starring.util.Encry;
import com.sun.org.apache.bcel.internal.classfile.Utility;
import org.apache.commons.lang.StringEscapeUtils;
import sun.reflect.generics.tree.ByteSignature;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalField;

/**
 *
 * @author wangchong
 * @date 2019/2/25
 */
public class AdtecEncry {

    public static void main(String[] args) {
        String outerPasswd = "upcoutertestdb";
        String busiPasswd = "upctestdb";
        System.out.println("外联：" + Encry.encryString(outerPasswd));
        System.out.println("模型：" + Encry.encryString(busiPasswd));
        String str = "adsfsafa'dsfs%d-fs";
        System.out.println(StringEscapeUtils.escapeSql(str));
        System.out.println(str.replaceAll("[%_'\"&]", ""));

        LocalTime now1 = LocalTime.of(16, 30, 30);
        LocalTime now2 = LocalTime.now();

        System.out.println(now1.compareTo(now2));
    }
}
