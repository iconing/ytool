package tcpprotocol;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 农信银密钥下载
 */
public class QsDownload {
    private static String ip = "172.16.37.1";
    private static int port = 32103;
    private static String fmt = "<?xml version=\"1.0\" encoding=\"GBK\"?><union><head><serviceCode>E113</serviceCode><sysID>QS</sysID><appID>QS</appID><clientIPAddr>10.135.0.3</clientIPAddr><transTime>20181205105115</transTime><transFlag>1</transFlag></head><body><keyName>QS.7000.zak</keyName><protectFlag>1</protectFlag><protectKey>QS.7000.zmk</protectKey></body></union>";

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(ip, port);
        System.out.println("连接主机:->" + ip + ":" + port);
        OutputStream os = socket.getOutputStream();

        int strLen = fmt.length();


        byte[] b = new byte[2];
        b[0] = (byte) (312 >> 8 & 0xFF);
        b[1] = (byte) (312 & 0xFF);

        byte[] itemData = fmt.getBytes("GBK");

        byte[] b1 = new byte[itemData.length + 2];
        System.arraycopy(b, 0, b1, 0, 2);
        System.arraycopy(itemData, 0, b1, 2, itemData.length);

        os.write(b1);
        System.out.println("发送数据:->" + new String(b1));
        os.flush();
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        byte[] recvArr = new byte[1024];
        String str = "";
        System.out.println("开始接受数据:->");
        while (is.read(recvArr) != -1) {
            str += new String(recvArr, "GBK");
        }
        System.out.println("接受数据:->" + str);
        socket.close();
    }
}
