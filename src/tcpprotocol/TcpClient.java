package tcpprotocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class TcpClient {
    private Socket socket;

    public TcpClient(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        System.out.println("连接主机：->" + ip + ":" + port + " 成功");
    }

    public void send(String content) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(content.getBytes("utf-8"));
        System.out.println("发送数据：->" + content);
    }

    public String recive() throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] temp = new byte[1024];
        byte[] result = new byte[10240];
        int index = 0;
        int readLen;
        while((readLen = inputStream.read(temp)) != -1) {
            System.arraycopy(temp, 0, result, index, readLen);
            index += readLen;
        }

        byte[] recives = Arrays.copyOf(result, index);

        System.out.println("接收数据字节数: " + recives.length);
        System.out.println("接收数据: " + new String(recives));
        return new String(recives);

        /**
         *
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int readCount;
        do {
            readCount = inputStream.read(temp);
            bos.write(temp, 0, readCount);
        } while (inputStream.available() != -1);
         */
    }

    public void close() throws IOException {
        this.socket.close();
    }



}
