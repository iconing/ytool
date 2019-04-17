package logAnly;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogBean {
    private String threadNum;
    private String seqNo;
    private Date date;
    private String svrName;
    private String phaseCode;

    public String getThreadNum() {
        return threadNum;
    }

    public LogBean() {
    }

    public LogBean(String input) {
        int stIndex = input.indexOf("] SEQ[") + 6;
        int end = input.indexOf("] REQ[");
        this.seqNo = input.substring(stIndex, end);

        stIndex = input.indexOf("REQ[] [") + 7;
        end = input.indexOf("] [DEBUG]");
        String tempStr = input.substring(stIndex, end);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
        try {
            this.date = sdf.parse(tempStr);
        } catch(ParseException e) {
            e.printStackTrace();
        }

        stIndex = input.indexOf("].[") + 3;
        end = input.indexOf("----");
        this.svrName = input.substring(stIndex, end);

        this.phaseCode = input.substring(end + 4, input.length() - 1);

        end = input.indexOf(":STEP[");
        this.threadNum = input.substring(10, end);

    }

    public LogBean(String threadNum, String seqNo, Date date, String svrName, String phaseCode) {
        this.threadNum = threadNum;
        this.seqNo = seqNo;
        this.date = date;
        this.svrName = svrName;
        this.phaseCode = phaseCode;
    }

    public void setThreadNum(String threadNum) {
        this.threadNum = threadNum;
    }

    public String getSeqNo() {
        return seqNo;
    }

    @Override
    public String toString() {
        return "LogBean{" +
                "threadNum='" + threadNum + '\'' +
                ", seqNo='" + seqNo + '\'' +
                ", date=" + date +
                ", svrName='" + svrName + '\'' +
                ", phaseCode='" + phaseCode + '\'' +
                '}';
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSvrName() {
        return svrName;
    }

    public void setSvrName(String svrName) {
        this.svrName = svrName;
    }

    public String getPhaseCode() {
        return phaseCode;
    }

    public void setPhaseCode(String phaseCode) {
        this.phaseCode = phaseCode;
    }
}
