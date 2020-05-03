package Engulf.JDBC.Practice;

import Engulf.Util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  测试：
 *  * JDBC工具类
 */

public class JDBCDemo8 {
    public static void main(String[] args) {
        List<Stu> list = new JDBCDemo8().findAll();
        System.out.println(list);
    }


    public List<Stu> findAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        List<Stu> list = new ArrayList<Stu>();
        //1.注册驱动

        try {
            conn = JDBCUtil.getConn();
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
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeSource(rs,state,conn);
        }
        return list;
    }
}
