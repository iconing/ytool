package javaio.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class PropertiesFileReader {
    private static Hashtable<String, String> ini = null;
    static{
        if (ini == null) {
            ini = new Hashtable<>(15);
        } else {
            ini.clear();
        }
        String iniPath = "C:\\Users\\Admin\\Desktop\\aa.ini";
        Properties prop = new Properties();
        //这里用reader是为了处理中文。
        try(Reader fs = new InputStreamReader(new FileInputStream(iniPath), "utf-8")) {
            prop.load(fs);
            Enumeration e = prop.propertyNames();
            while(e.hasMoreElements()) {
                String key = (String)e.nextElement();
                ini.put(key, prop.getProperty(key));
            }
        } catch(IOException ignored) {
            ignored.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ini.toString());
    }

    /**
     * 根据键值获取配置文件里的值。
     */
    public static String getIni(String key) throws ClassNotFoundException {
        String result = "";

        //检查参数，参数为空时返回空串
        if(key==null||"".equals(key)){
            return result;
        }

        //第一次执行此方法时，初始化ini到内存
        if(ini==null) {
            Class.forName(PropertiesFileReader.class.getName());
        }

        //获取值
        if(ini.containsKey(key)) {
            result = ini.get(key);
        } else {
        }

        return result;
    }
}
