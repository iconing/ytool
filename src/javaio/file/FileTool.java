package javaio.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileTool {

    public static File[] getFilesIn(String dirPath, String regex) throws Exception {
        File dir = new File(dirPath);
        FilenameFilter filter = null;
        boolean filterFlag = regex != null;
        if (filterFlag) {
            Pattern compile = Pattern.compile(regex);
            filter = (d, name) -> compile.matcher(name).find();
        }

        if (dir.isDirectory()) {
            if (filterFlag) {
                return dir.listFiles(filter);
            } else {
                return dir.listFiles();
            }
        }

        throw new Exception(dirPath + "不是一个目录");
    }

    public static File[] getAllFilesIn(String dirPath) throws Exception {
        return getFilesIn(dirPath, null);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readLinesFrom("F:\\desktop\\asdf.xml").get(0));
    }

    /**
     * 读取某一目录下所有文件的所有行
     * @param dirPath
     *              目录
     */
    public static List<String > readDirAllLines(String dirPath, String regex) throws Exception {
        File[] files = getFilesIn(dirPath, regex);
        if (files == null) {
            throw new Exception("该路径[" + dirPath + "]下没有文件！");
        }

        List<String> contList = new ArrayList<String>(100);

        BufferedReader br = null;
        String lineStr;
        for (File f : files) {
            // br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            br = new BufferedReader(new FileReader(f));

            while((lineStr = br.readLine()) != null) {
                contList.add(lineStr);
            }
        }
        if (br != null) {
            br.close();
        }

        return contList;
    }

    public static List<String > readDirAllLines(String dirPath) throws Exception {
        return readDirAllLines(dirPath, null);
    }

    public static void saveLinesTo(String filePath, List<String> lines) throws FileNotFoundException {
        System.out.println("写入文件[" + filePath + "]开始。。。");
        try (PrintWriter pw = new PrintWriter(filePath)) {
            lines.forEach(t -> {pw.write(t);pw.write("\n");});
            pw.flush();
        }
        System.out.println("写入文件[" + filePath + "]结束。。。");
    }

    static byte[] read_tempFile(String path) throws Exception {
        byte[] bufferBytes = new byte[1024];
        byte[] sumByte = new byte[128 * 1024 + 1];
        int index = 0;
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(path))) {
            int c;
            while ((c = bin.read(bufferBytes)) != -1) {
                System.arraycopy(bufferBytes, 0, sumByte, index, c);
                index += c;
            }
        }
        return Arrays.copyOf(sumByte, index);
    }

    /**
     * 以默认的编码(utf8)读取文件所有行
     */
    public static List<String> readLinesFrom(String fileName) throws IOException {
        return readLinesFrom(fileName, "UTF-8");
    }

    /**
     * 读取java项目resource路径下的文件的所有行
     */
    public static List<String> readResourceFileLines(InputStream resourceFile) throws IOException {
        return readLinesFrom(resourceFile, "utf-8");
    }

    /**
     * 以指定编码读取文件所有行
     *
     * @param charsetName
     *              字符编码
     */
    public static List<String> readLinesFrom(String fileName, String charsetName) throws IOException {
        System.out.println("文件路径[" + fileName + "]");
        return readLinesFrom(new FileInputStream(fileName), charsetName);
    }

    /**
     * 从输入流里读取文件所有行
     */
    public static List<String> readLinesFrom(InputStream ins, String charset) throws UnsupportedEncodingException {
        List<String> contLines = new ArrayList<>();
        String lineStr;
        System.out.println("读取文件开始。。。");
        InputStreamReader inputStreamReader = new InputStreamReader(ins, charset);
        try( BufferedReader br = new BufferedReader(inputStreamReader)){
            while((lineStr = br.readLine()) != null) {
                contLines.add(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读取文件结束：共有[" + contLines.size() + "]行");
        return contLines;
    }

    /**
     * 新建一个新的文件，如果已经存在则删除旧的。
     */
    static File getNewFile(String fileName) {
        File newFile = new File(fileName);
        if (newFile.exists()) {
            newFile.delete();
        }

        // File dir = new File(fileName.substring(0, fileName.lastIndexOf(File.pathSeparator)));
        // if (!dir.exists()) {
        //     dir.mkdirs();
        // }

        return newFile;
    }





}
