package tcpprotocol;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Aaaaa {
    // private static String ip = "11.18.14.41";
    private static String ip = "11.18.14.145";
    private static int port = 8025;
    private static String str = "00002841<?xml version='1.0'  encoding='UTF-8' ?><transaction>  <header>    <version>1.0</version>    <security>      <loginUser>JZZY</loginUser>      <requestIp>11.18.14.30</requestIp>    </security>    <message>      <msgType>UPCS.030500400.01</msgType>      <msgId>JZZY20190402282812202725</msgId>      <sndDt>20190402</sndDt>      <callTyp>SYN</callTyp>      <sndTm>030917715</sndTm>      <appCd>UPCS</appCd>      <reqAppCd>JZZY</reqAppCd>    </message>  </header>  <body>    <request>      <vocationalHeader>        <serviceCode>3050040</serviceCode>        <tfOrigChannel>JZZY</tfOrigChannel>        <tfChannel>JZZY</tfChannel>        <externalTask>3050040</externalTask>        <externalBranchCode>2510001</externalBranchCode>        <userId>108082</userId>        <postingDateText>0</postingDateText>        <xipDate>20190402</xipDate>        <userReferenceNumber>JZZY20190402000000000186080</userReferenceNumber>        <trackNumber>JZZY20190402000000000186080</trackNumber>      </vocationalHeader>      <xfaceTradeDTO>        <UPCS3050040DTO>          <BODY>            <VCH_TP>2</VCH_TP>            <EXAMNO/>            <PAY_LVL>1</PAY_LVL>            <CASH_TRF_FLG>1</CASH_TRF_FLG>            <DE_ACCT_TP>6</DE_ACCT_TP>            <TRF_METH>02</TRF_METH>            <DE_ACCT>2511010001201100020373</DE_ACCT>            <PAY_ACCT>2511010001201100020373</PAY_ACCT>            <DE_ACCT_NAME>农信人</DE_ACCT_NAME>            <PAY_ACCT_NAME>农信人</PAY_ACCT_NAME>            <TRAN_AMT>100.00</TRAN_AMT>            <FEE_CASH_TRF_FLG>1</FEE_CASH_TRF_FLG>            <DEF_FRT>100</DEF_FRT>            <REAL_FEE_AMT>5.00</REAL_FEE_AMT>            <TRAN_CURR>CNY</TRAN_CURR>            <PAYEE_ACCT>2201010001201100030142</PAYEE_ACCT>            <PAYEE_ACCT_NAME>农信人</PAYEE_ACCT_NAME>            <VCH_DATE>20181128</VCH_DATE>            <PAY_POSTS>1</PAY_POSTS>            <PAY_PWD>505626</PAY_PWD>            <VCH_NO>1</VCH_NO>            <ROUTE_NO>03</ROUTE_NO>            <BANK_BUSI_TP>A100</BANK_BUSI_TP>            <BANK_BUSI_KD>02102</BANK_BUSI_KD>            <ROUTE_BUSI_TP>A100</ROUTE_BUSI_TP>            <ROUTE_BUSI_KD>02102</ROUTE_BUSI_KD>            <PAY_BANK>402713052512</PAY_BANK>            <PAY_BANK_NAME>贵州凯里农村商业银行股份有限公司</PAY_BANK_NAME>            <PAY_CLR_BANK>402701002999</PAY_CLR_BANK>            <PAY_CLR_BANK_NAME>贵州省农村信用社联合社</PAY_CLR_BANK_NAME>            <PAYEE_BANK>314703023065</PAYEE_BANK>            <PAYEE_BANK_NAME>贵州遵义红花岗农村商业银行股份有限公司上海路支行</PAYEE_BANK_NAME>            <PAYEE_CLR_BANK>402701002999</PAYEE_CLR_BANK>            <PAYEE_CLR_BANK_NAME>贵州省农村信用社联合社</PAYEE_CLR_BANK_NAME>          </BODY>        </UPCS3050040DTO>      </xfaceTradeDTO>    </request>  </body></transaction>";
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(ip, port);
        System.out.println("连接主机:->" + ip + ":" + port);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        byte[] sendArr = str.getBytes();

        os.write(sendArr);
        System.out.println("发送数据:->" + str);
        os.flush();
        socket.shutdownOutput();
        String str = "";
        System.out.println("开始接受数据:->");
        byte[] recvArr = new byte[1024];
        while (is.read(recvArr) != -1) {
            str += new String(recvArr, StandardCharsets.UTF_8);
        }
        System.out.println("接受数据:->" + str);
        socket.close();
    }
}

