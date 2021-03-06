package com.example.youlidata;

import android.widget.EditText;

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

    public static String QuerySQL( String str)
    {
        String result = "";
        int count = 1;
        try
        {
            Connection conn = getSQLConnection("124.70.203.134", "sa", "Yelei193", "YouliData");
            String sql = "SELECT * FROM flow WHERE flo_num LIKE '%"+ str +"%'or flo_state LIKE '%"+str+"%'or flo_client LIKE '%"+str+"%'or flo_factory LIKE '%"+str+"%'or flo_coding LIKE '%"+str+"%'or flo_cilentID LIKE '%"+str+"%'or flo_model LIKE '%"+str+"%'or flo_logo LIKE '%"+str+"%'or flo_proname LIKE '%"+str+"%'" ;
            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                String s1 = rs.getString("flo_state");
                String s2 = rs.getString("flo_client");
                String s3 = rs.getString("flo_factory");
                String s4 = rs.getString("flo_num");
                String s5 = rs.getString("flo_record");
                String s6 = rs.getString("flo_coding");
                String s7 = rs.getString("flo_cilentID");
                String s8 = rs.getString("flo_model");
                String s9 = rs.getString("flo_logo");
                String s10 = rs.getString("flo_proname");
                String s11 = rs.getString("flo_range");
                String s12 = rs.getString("flo_unit");
                String s13 = rs.getString("flo_reunit");
                String s14 = rs.getString("flo_memunit");
                String s15 = rs.getString("flo_frames");
                String s16 = rs.getString("flo_backcolor");
                String s17 = rs.getString("flo_closetime");
                String s18 = rs.getString("flo_backtime");
                String s19 = rs.getString("flo_revise");
                String s20 = rs.getString("flo_cleRange");
                String s21 = rs.getString("flo_cleShutdown");
                String s22 = rs.getString("flo_gravity");
                String s23 = rs.getString("flo_levFacSet");
                String s24 = rs.getString("flo_cell");
                String s25 = rs.getString("flo_plastic");
                String s26 = rs.getString("flo_quantity");
                String s27 = rs.getString("flo_delivery");
                String s28 = rs.getString("flo_encase");
                String s29 = rs.getString("flo_box");
                String s30 = rs.getString("flo_ask");
                String s31 = rs.getString("flo_bomVerify");
                String s32 = rs.getString("flo_starv");
                String s33 = rs.getString("flo_oliquan");
                String s34 = rs.getString("flo_elequan");
                String s35 = rs.getString("flo_elsequan");
                String s36 = rs.getString("flo_facAlter");
                String s37 = rs.getString("flo_fristMake");
                String s38 = rs.getString("flo_fristChk");
                String s39 = rs.getString("flo_ProSum");
                String s40 = rs.getString("flo_spotChk");
                String s41 = rs.getString("flo_out");
                String s42 = rs.getString("flo_finish");

                result += "\n【订单序号】："+count
                        +"\n【订单状态】："+s1
                        + "\n【客户】：" + s2
                        +  " \n【工厂】：" + s3
                        + "\n【制令单号】：" + s4
                        +" \n【订单临时变更】：" + s5
                        + "\n【产品编号】：" + s6
                        + "\n【客户编号】" + s7
                        + "\n【客户机型】： " + s8
                        +"\n【LOGO】 ： " + s9
                        +"\n【工厂机型】：" + s10
                        +"\n【量程精度】：" + s11
                        +"\n【称重单位】：" + s12
                        +"\n【断电开机】：" + s13
                        +"\n【记忆单位】：" + s14
                        +"\n【开机画面】：" + s15
                        +"\n【背光颜色】：" + s16
                        +"\n【关机时间】：" + s17
                        +"\n【背光时间】：" + s18
                        +"\n【校机砝码】：" + s19
                        +"\n【自有程序】：" + s20
                        +"\n【内配功能】：" + s21
                        +"\n【内重力加速度配功能】：" + s22
                        +"\n【出厂标准】：" + s23
                        +"\n【电池】：" + s24
                        +"\n【塑胶颜色】：" + s25
                        +"\n【订单数量】：" + s26
                        +"\n【交货日期】：" + s27
                        +"\n【装箱方式】：" + s28
                        +"\n【箱唛】：" + s29
                        +"\n【客户细节要求】：" + s30
                        +"\n【物料需求提交状态】：" + s31
                        +"\n【报缺情况】：" + s32
                        +"\n【喷釉丝印】：" + s33
                        +"\n【委外电镀】：" + s34
                        +"\n【其他委外】：" + s35
                        +"\n【厂发变更记录】：" + s36
                        +"\n【首件制作】：" + s37
                        +"\n【首件确认】：" + s38
                        +"\n【生产问题汇总】：" + s39
                        +"\n【成品问题汇总】：" + s40
                        +"\n【出货操作】：" + s41
                        +"\n【结单操作】：" + s42
                        +"\n_________________________________________________";
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
       // QuerySQL(str);
    }
}