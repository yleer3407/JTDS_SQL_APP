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
            String sql = "select * from flow";
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

                result += "\n【订单序号："+count+"】"
                        +"\n订单状态："+s1
                        + "\n客户：" + s2
                        +  " \n工厂：" + s3
                        + "\n制令单号：" + s4
                        +" \n订单临时变更：" + s5
                        + "\n产品编号：" + s6
                        + "\n客户编号" + s7
                        + "\n客户机型： " + s8
                        +"\nLOGO ： " + s9
                        +"\n工厂机型：" + s10
                        +"\n量程精度：" + s11
                        +"\n称重精度：" + s12
                        +"\n称重单位：" + s13
                        +"\n断电开机：" + s14
                        +"\n记忆单位：" + s15
                        +"\n开机画面：" + s16
                        +"\n背光颜色：" + s17
                        +"\n关机时间：" + s18
                        +"\n背光时间：" + s19
                        +"\n校机砝码：" + s20
                        +"\n自有程序：" + s21
                        +"\n内配功能：" + s22
                        +"\n重力加速度：" + s23
                        +"\n出厂标准：" + s24
                        +"\n电池：" + s25
                        +"\n塑胶颜色：" + s26
                        +"\n订单数量：" + s27
                        +"\n交货日期：" + s28
                        +"\n装箱方式：" + s29
                        +"\n箱唛：" + s30
                        +"\n客户细节要求：" + s31
                        +"\n物料需求提交状态：" + s32
                        +"\n报缺情况：" + s33
                        +"\n喷釉丝印：" + s34
                        +"\n委外电镀：" + s35
                        +"\n其他委外：" + s36
                        +"\n厂发变更记录：" + s37
                        +"\n首件制作：" + s38
                        +"\n首件确认：" + s39
                        +"\n生产问题汇总：" + s40
                        +"\n成品问题汇总：" + s41
                        +"\n出货操作：" + s42
                        +"\n结单操作：" + s12 +"\n-------------------------------------------";
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