package Engulf.JDBC.Practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习：
 *  * 定义一个方法，查询stu表的数据将其封装为对象，然后装载集合，返回
 *      1.定义stu类
 *      2.定义方法 public List<stu> findAll(){}
 *      3.实现方法 select * from stu;
 */

public class JDBCDemo7 {
    public static void main(String[] args) {
        List<Stu> list = new JDBCDemo7().findAll();
        System.out.println(list);
    }


    public List<Stu> findAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        List<Stu> list = new ArrayList<Stu>();
        //1.注册驱动

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","52snowgnar");
            //3.定义sql
            String sql = "select * from stu";
            //4.获取执行sql对象
            state = conn.createStatement();
            //5.执行sql
            rs = state.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Stu stu = null;

            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                Date birth = rs.getDate("birth");

                stu = new Stu();
                stu.setId(id);
                stu.setName(name);
                stu.setBirth(birth);
                stu.setScore(score);
                stu.setAge(age);

                list.add(stu);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }
}
