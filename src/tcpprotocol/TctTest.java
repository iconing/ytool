package tcpprotocol;

import javaio.file.FileTool;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TctTest {
    private static final String IP = "11.18.14.41";
    private static final int PORT = 8025;
    TcpClient client = new TcpClient(IP, PORT);
    public static final String BASE_DIR = "C:\\Users\\Administrator\\desktop\\ndbt_test\\inner\\";

    public TctTest() throws IOException {
    }

    private String getContentFrom(String fileName) throws IOException {
        List<String> lines = FileTool.readLinesFrom(fileName);
        String all = lines.stream()
                .map(s -> s.replaceAll(" ", ""))
                .collect(Collectors.joining(""));
        System.out.println(all.length());
        String headLenth = String.format("%08d", all.getBytes("utf-8").length);
        return headLenth + all;
    }

    private void handle(String fileName) throws IOException {
        String content = getContentFrom(BASE_DIR + fileName);
        client.send(content);
        client.recive();
        client.close();
    }

    /**
     * 列表查询
     */
    @Test
    public void sendQryList() throws IOException {
        handle("3090010qryList.txt");
    }

    /**
     * 详细信息查询
     */
    @Test
    public void sendQryDetail() throws IOException {
        handle("3090020req");
    }

    /**
     * 往账录入
     */
    @Test
    public void sendInput() throws IOException {
        handle("3090040req.txt");
    }

    /**
     * 往账录入
     */
    @Test
    public void sendInputBeps() throws IOException {
        handle("3090040req_beps");
    }

    /**
     * 往账修改
     */
    @Test
    public void sendEdit() throws IOException {
        handle("3090050req.txt");
    }

    /**
     * 往账复核
     */
    @Test
    public void sendCheck() throws IOException {
        handle("3090070req");
    }

    /**
     * 解付更正
     */
    @Test
    public void send3090140() throws IOException {
        handle("3090140req.txt");
    }

    /**
     * 回执修改
     */
    @Test
    public void send3090100() throws IOException {
        handle("3090100req");
    }

    /**
     * 回执解付抹账
     */
    @Test
    public void send3090190() throws IOException {
        handle("3090190req");
    }

    /**
     * 回执解付复核
     */
    @Test
    public void send3090200() throws IOException {
        handle("3090200req");
    }

    /**
     * 解付更正录入
     */
    @Test
    public void send3090210() throws IOException {
        handle("3090210req");
    }

    public static void main(String[] args) {
        int l = 258;
        byte b1 = 258 >> 8 & 0xFF;
        byte b2 = 258 & 0xFF;
    }
}
