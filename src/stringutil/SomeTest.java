package stringutil;

/**
 *
 * @author wangchong
 */
public class SomeTest {

    /**
     * REQ_COMP_NO :
     * REQ_NODE_NO :
     * REQ_IP :
     * REQ_DATE :
     * REQ_SVC_CODE :
     * REQ_SEQ :
     * SND_COMP_NO :
     * SND_NODE_NO :
     * SND_DATE : 20181008
     * SND_SEQ : ITLR3319101003365555
     * OUT_DATE : 20181008
     * OUT_TIME : 154015
     * OUT_SEQ : ITLR3319101003365555
     * REQ_PLAT_SEQ :
     * VER_NO :
     * OUT_SYS : ITLR
     */

    private String REQ_COMP_NO;
    private String REQ_NODE_NO;
    private String REQ_IP;
    private String REQ_DATE;
    private String REQ_SVC_CODE;
    private String REQ_SEQ;
    private String SND_COMP_NO;
    private String SND_NODE_NO;
    private String SND_DATE;
    private String SND_SEQ;
    private String OUT_DATE;
    private String OUT_TIME;
    private String OUT_SEQ;
    private String REQ_PLAT_SEQ;
    private String VER_NO;
    private String OUT_SYS;

    public static void main(String[] args) {
        String[] status = {"57", "59"};
        StringBuilder sb = new StringBuilder();
        boolean hasTranStat = false;
        boolean hasBatStat = false;
        for (String s : status) {
            if ("55".equals(s)) {
                hasTranStat = true;
            } else {
                hasBatStat = true;
            }
        }

        if (hasBatStat) {
            sb.append(" and recv_bat_stat in (");
            for (int i = 0; i < status.length; i++) {
                if (!"55".equals(status[i])) {
                    sb.append("'").append(status[i]).append("'");
                    if(i < (status.length - 1)) {
                        sb.append(", ");
                    }

                    if(i == (status.length - 1)) {
                        sb.append(") ");
                    }
                }
            }
        }

        if (hasTranStat) {
            sb.append(" and tran_stat = '55' ");
        }

        System.out.println(sb.toString());
    }

    public String getREQ_COMP_NO() {
        return REQ_COMP_NO;
    }

    public void setREQ_COMP_NO(String REQ_COMP_NO) {
        this.REQ_COMP_NO = REQ_COMP_NO;
    }

    public String getREQ_NODE_NO() {
        return REQ_NODE_NO;
    }

    public void setREQ_NODE_NO(String REQ_NODE_NO) {
        this.REQ_NODE_NO = REQ_NODE_NO;
    }

    public String getREQ_IP() {
        return REQ_IP;
    }

    public void setREQ_IP(String REQ_IP) {
        this.REQ_IP = REQ_IP;
    }

    public String getREQ_DATE() {
        return REQ_DATE;
    }

    public void setREQ_DATE(String REQ_DATE) {
        this.REQ_DATE = REQ_DATE;
    }

    public String getREQ_SVC_CODE() {
        return REQ_SVC_CODE;
    }

    public void setREQ_SVC_CODE(String REQ_SVC_CODE) {
        this.REQ_SVC_CODE = REQ_SVC_CODE;
    }

    public String getREQ_SEQ() {
        return REQ_SEQ;
    }

    public void setREQ_SEQ(String REQ_SEQ) {
        this.REQ_SEQ = REQ_SEQ;
    }

    public String getSND_COMP_NO() {
        return SND_COMP_NO;
    }

    public void setSND_COMP_NO(String SND_COMP_NO) {
        this.SND_COMP_NO = SND_COMP_NO;
    }

    public String getSND_NODE_NO() {
        return SND_NODE_NO;
    }

    public void setSND_NODE_NO(String SND_NODE_NO) {
        this.SND_NODE_NO = SND_NODE_NO;
    }

    public String getSND_DATE() {
        return SND_DATE;
    }

    public void setSND_DATE(String SND_DATE) {
        this.SND_DATE = SND_DATE;
    }

    public String getSND_SEQ() {
        return SND_SEQ;
    }

    public void setSND_SEQ(String SND_SEQ) {
        this.SND_SEQ = SND_SEQ;
    }

    public String getOUT_DATE() {
        return OUT_DATE;
    }

    public void setOUT_DATE(String OUT_DATE) {
        this.OUT_DATE = OUT_DATE;
    }

    public String getOUT_TIME() {
        return OUT_TIME;
    }

    public void setOUT_TIME(String OUT_TIME) {
        this.OUT_TIME = OUT_TIME;
    }

    public String getOUT_SEQ() {
        return OUT_SEQ;
    }

    public void setOUT_SEQ(String OUT_SEQ) {
        this.OUT_SEQ = OUT_SEQ;
    }

    public String getREQ_PLAT_SEQ() {
        return REQ_PLAT_SEQ;
    }

    public void setREQ_PLAT_SEQ(String REQ_PLAT_SEQ) {
        this.REQ_PLAT_SEQ = REQ_PLAT_SEQ;
    }

    public String getVER_NO() {
        return VER_NO;
    }

    public void setVER_NO(String VER_NO) {
        this.VER_NO = VER_NO;
    }

    public String getOUT_SYS() {
        return OUT_SYS;
    }

    public void setOUT_SYS(String OUT_SYS) {
        this.OUT_SYS = OUT_SYS;
    }
}
