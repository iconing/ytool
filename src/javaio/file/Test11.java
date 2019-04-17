package javaio.file;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

public class Test11 {

    @Test
    public void test11() throws Exception {
        String sssss = "01";
        String[] qryStatus = sssss.split("\\|");
        System.out.println(Arrays.toString(sssss.split("\\|")));

        sssss = " in ('";
        sssss += (Arrays.stream(qryStatus)
                .collect(Collectors.joining("', '")));
        sssss += "')";
        System.out.println(sssss);


        System.out.println("开始合并文件。。。");
        int totalNu = 49;
        byte[] maxBytes = new byte[totalNu * 128 * 1024];

        String tempDir = "E:\\test\\upsouter\\Pay\\";
        int index = 0;
        byte[] tempBytes;
        for (int i = 1; i <= totalNu; i++) {
            // tempBytes = read_tempFile(tempDir + checkWaitDetail.getMpsTempFileName(i));
            // this.getStartWorkDate()
            //                 + "_" + this.getEndWorkDate()
            //                 + "_" + this.getMpsFileCount()
            //                 + "_" + index + ".txt"
            String tem = tempDir + "20180827_20180827_49_" + i + ".txt";
            tempBytes = FileTool.read_tempFile(tem);
            System.arraycopy(tempBytes, 0, maxBytes, index, tempBytes.length);
            index = index + tempBytes.length;
        }

        String mergeFilePrefix = "E:\\test\\upsouter\\merge\\aaa";
        File base64File = FileTool.getNewFile(mergeFilePrefix + "_all.base64");

        try (OutputStream out = new FileOutputStream(base64File)) {
            out.write(maxBytes, 0, index);
            out.flush();
            out.close();
        }

        File gzFile = FileTool.getNewFile(mergeFilePrefix + "_all.gz");
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
        }

        File allTxt = FileTool.getNewFile(mergeFilePrefix + "_all.txt");
        try (BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(
                                new FileInputStream(gzFile)
                        )
                )
        );
             BufferedOutputStream out = new BufferedOutputStream(
                     new FileOutputStream(allTxt))) {
            String s;
            while ((s = in2.readLine()) != null) {
                out.write((s + "\n").getBytes("utf-8"));
            }
            out.flush();
            out.close();
            in2.close();
            //删除临时文件。
            base64File.delete();
//            gzFile.delete();
        }
    }

    @Test
    public void extract0160Format() throws Exception {
        String fileRegex = "^(NetBank).*";
        String inDir = "G:\\netbank1-20180215\\20180215\\rcb\\";
        File[] files = FileTool.getFilesIn(inDir, fileRegex);

        System.out.println(files.length);

        BufferedReader br = null;
        PrintWriter pw = null;

        String outDir = "G:\\netbank1-20180215\\20180215\\parsed\\";
        // Pattern compile = Pattern.compile("msgCd>CBSMPS00[123]0");
        Pattern compile = Pattern.compile("msgCd>CBSMPS0160");
        Matcher matcher;
        String temp;
        long start;
        int index = 0;

        List<String> linesFor0160 = new ArrayList<>(100);

        try {
            for (File file : files) {
                start = System.currentTimeMillis();

                String inPath = file.getAbsolutePath();
                String outPath = outDir + file.getName() + "_parsed.txt";

                br = new BufferedReader(new FileReader(inPath));
                while ((temp = br.readLine()) != null) {
                    matcher = compile.matcher(temp);
                    if (matcher.find()) {
                        temp = temp.substring(temp.indexOf("<transaction"), temp.length() - 1);
                        linesFor0160.add(temp + "\n");
                    }
                }
                System.out.println(index + "-- 解析[" + file.getName() + "]耗时: " + (System.currentTimeMillis() - start) + "ms");
                index ++;
            }

            pw = new PrintWriter(outDir + "CBSMPS0160.txt");
            linesFor0160.forEach(pw::write);
            pw.flush();
            System.out.println("写入文件完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
            assert pw != null;
            pw.close();
        }

    }

    public static void main(String[] args) throws Exception {

        String fileRegex = "^(NetBank).*";
        String inDir = "G:\\netbank1-20180215\\20180215\\rcb\\";
        File[] files = FileTool.getFilesIn(inDir, fileRegex);

        System.out.println(files.length);

        BufferedReader br = null;
        PrintWriter pw = null;


        String outDir = "G:\\netbank1-20180215\\20180215\\parsed\\";
        // Pattern compile = Pattern.compile("msgCd>CBSMPS00[123]0");
        Pattern compile = Pattern.compile("msgCd>CBSMPS0160");
        Matcher matcher;
        String temp;
        long start;
        int index = 0;

        try {
            for (File file : files) {
                start = System.currentTimeMillis();

                String inPath = file.getAbsolutePath();
                String outPath = outDir + file.getName() + "_parsed.txt";

                br = new BufferedReader(new FileReader(inPath));
                pw = new PrintWriter(outPath);
                while ((temp = br.readLine()) != null) {
                    matcher = compile.matcher(temp);
                    if (matcher.find()) {
                        temp = temp.substring(temp.indexOf("<transaction"), temp.length() - 1);
                        pw.write(temp + "\n");
                    }
                }
                pw.flush();
                System.out.println(index + "-- 解析[" + file.getName() + "]耗时: " + (System.currentTimeMillis() - start) + "ms");
                index ++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
            assert pw != null;
            pw.close();
        }
    }
}
