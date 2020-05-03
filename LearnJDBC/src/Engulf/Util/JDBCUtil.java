package Engulf.Util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */

public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 读取配置文件，只需要读取一次拿到对应的值
     * 使用静态代码块
     */
    static{
        //读取资源文件，获取值
        try {
            //1.创建Properties集合类
            Properties pro = new Properties();

            //2.加载配置文件
            //绝对路径
            //pro.load(new FileReader("D:\\IDEA\\JDBC\\LearnJDBC\\src\\jdbc.properties"));

            //获取src路径下的文件的方式-->ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            pro.load(new FileReader(path));

            //3.获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    /**
     * 获取连接
     * @return 连接对象
     */
    Connection conn = null;
    Statement state = null;
    ResultSet rs = null;
    public static Connection getConn() throws SQLException {
            return DriverManager.getConnection(url,user,password);
    }

    public static void closeSource(Statement state, Connection conn){
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeSource(ResultSet rs,Statement state, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
