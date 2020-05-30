package com.example.youlidata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil
{

    private static Connection getSQLConnection(String ip, String user, String pwd, String db)
    {
        Connection con = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + ip + ":1433/" + db + ";charset=utf8", user, pwd);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }

    public static String QuerySQL()
    {
        String result = "";
        int count = 1;
        try
        {
            Connection conn = getSQLConnection("175.24.20.254", "sa", "Yelei193", "YouliData");
            String sql = "select * from wlxq02";
            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                String s1 = rs.getString("时序");
                String s2 = rs.getString("制令单号");
                String s3 = rs.getString("产品编码");
                String s4 = rs.getString("产品名称");
                String s5 = rs.getString("数量");
                String s6 = rs.getString("Bom需要更改记录");
                String s7 = rs.getString("Bom更改操作");
                String s8 = rs.getString("已截屏");
                String s9 = rs.getString("厂制发料");
                String s10 = rs.getString("包装材料确认");
                String s11 = rs.getString("需求提交");
                String s12 = rs.getString("客户需求变更");
                result += "\n【订单序号："+count+"】"+"\n时序："+s1 + "\n制令单号：" + s2 +  " \n产品编码：" + s3+ "\n产品名称：" + s4 +" \n数量：" + s5+ "\nBom需要更改记录：" + s6+ "\nBom更改操作" + s7+ "\n已截屏： " + s8 +"\n厂制发料： " + s9 +"\n包装材料确认：" + s10 +"\n需求提交：" + s11+"\n客户需求变更：" + s12 +"\n-------------------------------";
                count++;
                System.out.println(s1 + "-" + s2 +  "-  " + s3+ "  -  " + s4 +"  -  " + s5+ "  - " + s6+ " - " + s7+ "  - " + s8 +"  - " + s9 +"  - " + s10 +"  - " + s11+"  -  " + s12+"\n");
                //System.out.println(s1 + "  -  " + s2);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }
        return result;
    }

    public static void main(String[] args)
    {
        QuerySQL();
    } }