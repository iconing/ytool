package javaio.gzip;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        // String fileCont = "1111aaaabbbb王冲|cccc|sdk.。，//，。。。00000";
        String path = "C:\\Users\\Admin\\Desktop\\";
        // String txtFileName = path + "test1.txt";
        // save2tempFile(txtFileName, fileCont);
        // System.out.println("写入完毕“");
        //
        // BufferedOutputStream bos = new BufferedOutputStream(
        //         new GZIPOutputStream(
        //                 new FileOutputStream(path + "test.txt.gz")
        //         )
        // );
        // BufferedReader in = new BufferedReader(new FileReader(path + "test333.txt"));
        // BufferedInputStream bin = new BufferedInputStream(
        //         new FileInputStream(txtFileName)
        // );
        // byte[] rb = new byte[256];
        // int c;
        // while((c = bin.read(rb)) != -1) {
        //     System.out.println(new String(rb, "utf-8"));
        //     bos.write(rb, 0, c);
        // }
        // bos.flush();
        // bos.close();
        //
        // System.out.println("压缩完毕");

        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(
                                new FileInputStream(path + "aaa.txt.gz")
                        )
                )
        );
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(path + "uncompress.txt")
        );

        String s;
        while((s = in2.readLine()) != null) {
            System.out.println(s);
            out.write((s+"\n").getBytes("utf-8"));
        }
        out.flush();
        in2.close();
        System.out.println("解压完毕");
    }

    /**
     * 将给定得字符串以默认得字符编码（Charset.defaultCharset())写入到文件。（utf-8)
     */
    private static boolean save2tempFile(String fileName, String fileCont) {
        try(PrintWriter pw = new PrintWriter(fileName);) {
            pw.write(fileCont);
            pw.flush();
        } catch(FileNotFoundException e) {
            return false;
        }
        return true;
    }

    private static String uncompress(String str) throws IOException {
       OutputStream os = new ByteArrayOutputStream();
       ByteArrayInputStream bi = new ByteArrayInputStream(str.getBytes("utf-8"));
       InputStream is = new GZIPInputStream(bi);

        return "";
    }
}
