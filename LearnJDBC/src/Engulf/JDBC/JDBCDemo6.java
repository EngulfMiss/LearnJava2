package Engulf.JDBC;

/**
 * 执行DDL语句
 */

import java.sql.*;

public class JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        ResultSet rs =null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","52snowgnar");
            //3.定义sql语句
            String sql = "select * from stu";
            //4.获取执行sql对象
            state = conn.createStatement();
            //5.执行sql
            rs = state.executeQuery(sql);
            //6.处理结果
            //6.1 让游标向下移动一行
            while(rs.next()) {
                //6.2获取shuju
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double score = rs.getDouble("score");

                System.out.println("ID:" + id + " ----" + " Name:" + name + " ---- " + "Score:" + score);
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
