package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        String ip = "127.0.0.1";
        String port = "1521";
        String sid = "orcal";
        String url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;
        try {
            String user = "upcouterdb";
            String passwd = "upcouterdb";
            return DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败：" + e.getMessage());
        }
    }
}
