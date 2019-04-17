package javaio.file;

/**
 * Class相关工具类
 * @author wangchong
 */
public class ClassTool {

    /**
     * 获取运行当前方法的类名
     */
    public static String getCurrClassName() {
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
        StackTraceElement ste = stackTraces[stackTraces.length - 1];
        String className = ste.getClassName();
        System.out.println("当前class名字：" + className);
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
