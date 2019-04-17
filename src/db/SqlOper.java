package db;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author wangchong
 */
public class SqlOper {

    public static void main(String[] args) {
        String insertSql = "INSERT INTO T_NCRD_BOOK ( CASH_REVS_PLAT_DATE,CLR_ACCT_PLAT_DATE,MSG_TP,MSG_TIME,AGENT_ACCT,MUAL_REVS_PLAT_DATE,PAYEE_ACCT,CHNL_NO,TRF_METH,PAY_CLR_BANK_NAME,EXAM_NO,TRAN_END_STAT,REAL_FEE_AMT,SUM_DESC,PAY_PWD,TRF_FEE_AMT,HOST_TIME,MUAL_ACCT_PLAT_SEQ,FREEZ_PLAT_SEQ,VCH_DATE,MUAL_ACCT_PLAT_DATE,FEE_CASH_TRF_FLG,FREEZ_SEQ,DE_ACCT,PAYEE_ACCT_ADDR,PAYEE_BANK,TRAN_BRCH,PAY_LVL,CASH_REVS_DATE,ORIG_TRAN_SEQ,LEGA_BRCH,PLAT_SEQ,DEF_FRT,FEE_SUM_DESC,DE_ACCT_TP,CASH_TRF_FLG,PAYEE_CLR_BANK,ACCT_OPER_TP,CLR_ACCT_SEQ,PAY_ACCT_NAME,OTH_STAT,MUAL_ACCT_DATE,HOST_PLAT_SEQ,INSPT_TLR_NO,UPT_TIME,AGENT_ACCT_NAME,PAY_ACCT,CLR_ACCT_DATE,PAYEE_OPEN_BANK_NAME,TRAN_RET_MSG,FREEZ_PLAT_DATE,TRAN_STAT,ROUTE_NO,SND_RCV_FLG,OTH_RET_CODE,FREEZ_DATE,BANK_BUSI_TP,CASH_REVS_SEQ,CALT_FEE_AMT,OPER_STAT,EXAM_TLR_NO,PAY_POSTS,TLR_OPER_TP,TX_ID,CR_DE_TP,BAT_DTL_SER,PAYEE_OPEN_BANK,BAT_DATE,TRAN_AMT,PRT_NUM,ROUTE_BUSI_TP,VCH_TP,PAY_BANK_NAME,RECV_BAT_STAT,MUAL_REVS_DATE,BANK_BUSI_KD,PAY_CLR_BANK,PAYEE_ACCT_NAME,PAY_BANK,FEE_SUM_CODE,MSG_ID,DE_ACCT_NAME,OTH_RET_MSG,BUSI_CLSS_NO,DE_ACCT_LVL,SUM_CODE,CLR_DATE,ROUTE_BUSI_KD,PAY_ACCT_ADDR,TRAN_CURR,CASH_REVS_PLAT_SEQ,CHNL_FLG,CLR_ACCT_PLAT_SEQ,CHNL_SEQ,MUAL_ACCT_SEQ,MUAL_REVS_SEQ,RFND_DESC,PAYEE_BANK_NAME,PAYEE_CLR_BANK_NAME,PAY_OPEN_BANK,SND_BANK_NAME,VCH_NO,PLAT_DATE,MUAL_REVS_PLAT_SEQ,CANCL_TLR_NO,CHNL_DATE,TRAN_TIME,AUTH_TLR_NO,TRAN_RET_CODE,BAT_SEQ,HOST_SEQ,LONG_RMRK,PAY_OPEN_BANK_NAME,HOST_PLAT_DATE,HOST_DATE,SND_BANK,REG_TLR_NO,ORIG_TRAN_DATE,RECV_BAT_FLG ) VALUES ( '','','','','','','6217790001100004072','ITLR','01','贵州省农村信用社联合社','','N',0.0,'','',0.0,'','','','','','1','','201101','','314701012010','2780002','1','','110000250516','11111','100002989844',1.0,'','8','1','402701002999','02','','1','','','','','20181210154630','','1','','','','','02','02','0','','','A105','',0.0,'0200','','贷记退汇','03','','2',0,'314701012010','',15.0,0,'A105','99','贵州黔西农村商业银行股份有限公司黔金支行','','','02108','402701002999','农信人','314709374542','','','','','1','','','','02108','','CNY','','0','','ITLR20191222030001430469','','','‘','贵阳农村商业银行股份有限公司云岩支行','贵州省农村信用社联合社','314709374542','贵州黔西农村商业银行股份有限公司黔金支行','','20181210','','','20191222','20181210154629','','','','','','','','','314709374542','117349','20181204','' )";

        int fieldStartIndex = insertSql.indexOf("(");
        int fieldEndIndex = insertSql.indexOf(")");
        String fieldStr = insertSql.substring(fieldStartIndex + 1, fieldEndIndex).trim();

        insertSql = insertSql.substring(fieldEndIndex + 1);
        int valueStartIndex = insertSql.indexOf("(");
        int valuesEndIndex = insertSql.indexOf(")");
        String valueStr = insertSql.substring(valueStartIndex + 1, valuesEndIndex).trim();

        String[] fields = fieldStr.split(",");
        String[] values = valueStr.split(",");

        String[] results = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            results[i] = (fields[i] + " = " + values[i]);
        }

        Arrays.sort(results); // 排序

        Arrays.stream(results).forEach(System.out::println);
    }
}
