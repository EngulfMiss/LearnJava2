package Engulf.JDBC;

/**
 * 执行DDL语句
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo5 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","52snowgnar");
            //3.定义sql语句
            String sql = "create table student (id int primary key, name varchar(20))";
            //4.获取执行sql对象
            state = conn.createStatement();
            //5.执行sql
            int count = state.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count >= 0){
                System.out.println("创建成功");
            }else{
                System.out.println("创建失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
}
