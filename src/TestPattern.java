import com.adtec.starring.util.StringTool;

import java.nio.file.attribute.AclEntryPermission;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    public static void main(String[] args) {
        String patternStr = "<RfuCd>(.*)</RfuCd>";
        Pattern p = Pattern.compile(patternStr);
        String str = " <TranSeqNb>13395172</TranSeqNb>\n" +
                "            <RfuCd>HOST-TF_XIP015</RfuCd>\n" +
                "            <RfuInfo>账户类型>错误</RfuInfo>";
        Matcher m = p.matcher(str);
        while(m.find()){
            System.out.println(m.start());
            System.out.println(m.group());
            System.out.println(m.replaceAll("<RfuCd>aaaa</RfuCd>"));
        }

        String pt = "^[1-9]\\d{3}(0[1-9]|1[0-2])(0[1-9]|1[0-2])$";
        String d = "20182202";
        System.out.println("dsfsldfjsdlkf:" + d.matches(pt));

        int i = 1;
        try {
            System.out.println(i / 0);
        } catch(Exception e) {
            i = 2;
            System.out.println("catch 里面的i " + i);
        } finally {
            i = 3;
            System.out.println("finally 里面的i " + i);
        }

        System.out.println("最终的i " + i);


        String clob = "1111|bbb";

        if (!StringTool.isNullOrEmpty(clob) && clob.contains("|")) {
            System.out.println(clob.split("\\|")[0]);
            System.out.println(clob.split("\\|")[1]);
        }
    }
}
