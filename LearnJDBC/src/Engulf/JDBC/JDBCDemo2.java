package Engulf.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * stu表添加一个数据
 * stu表修改一个数据
 * stu表删除一个数据
 */

public class JDBCDemo2 {
    public static void main(String[] args) {
        Statement state = null;
        Connection conn = null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "insert into stu values(3,'Tian',20,85,NULL,'2020-05-02')";
            //3.获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false","root","52snowgnar");
            //4.获取执行sql的对象 Statement
            state = conn.createStatement();
            //5.执行sql  count 为影响的行数
            int count = state.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            /* 避免空指针异常
            state.close();
            conn.close();
            */
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
