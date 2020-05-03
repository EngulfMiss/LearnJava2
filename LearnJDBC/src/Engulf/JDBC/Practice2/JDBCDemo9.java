package Engulf.JDBC.Practice2;

import Engulf.Util.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

/**
 * 登录验证
 */

public class JDBCDemo9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入用户名:");
        String username = input.next();
        System.out.println("输入密码：");
        String password = input.next();
        if(new JDBCDemo9().login(username,password)){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

    }


    public boolean login(String username,String password){
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        if(username == null || password == null){
            return false;
        }
        //连接数据库，判断是否成功
        //1.获取连接
        try {
            conn = JDBCUtil.getConn();
            //2.定义sql
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
            //3.获取执行sql的对象
            state = conn.createStatement();
            //4.执行查询
            rs = state.executeQuery(sql);
            //5.判断
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeSource(rs,state,conn);
        }
        return false;
    }
}
