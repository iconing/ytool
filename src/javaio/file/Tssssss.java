package javaio.file;

import java.io.*;
import java.util.Base64;

/**
 *
 * @author wangchong
 */
public class Tssssss {
    public static void main(String[] args) {
        File gzFile = new File("C:\\Users\\Administrator\\Desktop\\20181202.bak.gz");
        String base64File = "C:\\Users\\Administrator\\Desktop\\MPSPay.20181203.all.base64";
        Base64.Decoder decoder = Base64.getDecoder();
        try (InputStream in = decoder.wrap(new FileInputStream(base64File));
             OutputStream out1 = new FileOutputStream(gzFile)) {
            int rl;
            byte[] readByte = new byte[1024];
            while ((rl = in.read(readByte)) != -1) {
                out1.write(readByte, 0, rl);
                out1.flush();
            }
            in.close();
            out1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("生成结束");
    }
}
