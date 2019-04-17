package logAnly;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.rmi.server.ExportException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class LogFileHandler {

    public static List<LogBean> getAllLogInfoBy(String svrName, String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        List<LogBean> allLogBean = new ArrayList<>();
        String line = null;
        while((line = br.readLine()) != null) {
//            System.out.println(line);
            LogBean lb = new LogBean(line);
            if ("".equals(svrName)) {
                allLogBean.add(lb);
            } else {
                if (lb.getSvrName().equals(svrName)) {
                    allLogBean.add(lb);
                }
            }
        }
        System.out.println("日志总条数: " + allLogBean.size());
        if (allLogBean.size() <= 0) {
            throw new Exception("该文件没有输入的服务名:" + svrName);
        }
        return allLogBean;
    }

    public static void main(String[] args) throws Exception {
//        String svrName = "CBSMPS0080";
        String svrName = "";
        String logFilePath = "C:\\Users\\Admin\\Desktop\\temp\\all";
        List<LogBean> allLogBean= LogFileHandler.getAllLogInfoBy(svrName, logFilePath);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
        Date dateStr = sdf.parse("2017-12-28");

    }

}
