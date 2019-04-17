import javax.swing.text.SimpleAttributeSet;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestUseCase{

    @UseCase(id = 1, description = "方法1")
    public boolean validatePassword(String password) {
       return false;
    }

    @UseCase(id = 2)
    public String encryptPassword(String password) {
        return "123" + password;
    }

    @UseCase(id = 3, description = "method 3")
    public boolean checkForNewPassword() {
        return true;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ThreadLocal<String> sss = ThreadLocal.withInitial(() -> null);
        sss.set("1111111111111111111");
        System.out.println(sss.get());

        String ssss = "00001090<?xml version='1.0'  encoding='UTF-8' ?><transaction><body><request><xfaceTradeDTO><UPCS3053100DTO><BODY><STR_REC_SER>1</STR_REC_SER><PARA_STAT>01</PARA_STAT><REQ_REC_NUM>15</REQ_REC_NUM></BODY></UPCS3053100DTO></xfaceTradeDTO><vocationalHeader><postingDateText>0</postingDateText><tranName>快捷汇款刘毅</tranName><origExternalTask>3053100</origExternalTask><externalTask>3053100</externalTask><trackNumber>ITLR20190403030000759586</trackNumber><serviceCode>3053100</serviceCode><tfOrigChannel>UPCS</tfOrigChannel><userId>109015</userId><userReferenceNumber>ITLR20190403030000759586</userReferenceNumber><externalBranchCode>8100001</externalBranchCode><xipDate>20190403</xipDate><tfChannel>UPCS</tfChannel></vocationalHeader></request></body><header><security><loginUser>ITLR</loginUser><requestIp>11.18.14.31</requestIp></security><message><sndDt>20190403</sndDt><msgType>UPCS.030531000.01</msgType><reqAppCd>ITLR</reqAppCd><msgId>ITLR20190403030000759586</msgId><appCd>UPCS</appCd><sndTm>092511156</sndTm><callTyp>SYN</callTyp></message><version>1.0</version></header></transaction>";

        System.out.println(stringToAscii(ssss));

        int a = 0;
        for (int m = 0; m < 3; m++) {
            System.out.println("sfdfdf");
            a ++;
        }

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").format(LocalDateTime.now()));

        System.out.println(a);

        LocalTime now = LocalTime.now();
        boolean saadfa = now.getHour() >= 17 && now.getMinute() > 0;
        System.out.println(saadfa);
    }

    public static String stringToAscii(String input) {
        StringBuffer sb = new StringBuffer();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sb.append((int)chars[i]).append(" ");
            } else {
                sb.append((int)chars[i]);
            }

        }

        return sb.toString();
    }
}
