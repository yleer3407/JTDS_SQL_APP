package com.example.socket.linkdatabaseapplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DbUtil {

    private Connection connection;
    public static ArrayList<EnviromentQrder> typeLocationList;

    //连接数据库
    public Connection getSQLConnection(String ip, String user, String pwd, String db) throws Exception
    {
        Connection con = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");//固定写法
            //一定要在AndroidManifest.xml中加入socket权限，不然会包权限错误
            /*
              <uses-permission android:name="android.permission.INTERNET" />
              <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
              <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
             */
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + ip + ":1433/" + db + ";charset=utf8", user, pwd);//ip:数据库的IP  db：数据库名字 user:数据库用户名   pwd：用户名对应密码
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    //登陆
    public String QuerySQL(String name,String pass)
    {
        String result = "";
        try
        {
            //要想连接数据库必须导入相应的包在libs中（jtds-1.2.7.jar和sqljdbc.jar）
            connection= getSQLConnection("124.70.203.134", "sa", "Yelei193", "YoushangData");//连接数据库，修改为自己的，这个ip地址你们连不上。
            String sql = "select userID from userAdmin   where  userID=? and  userPwd=?"; //查询语句
            PreparedStatement stat = connection.prepareStatement(sql);//得到PreparedStatement对象
            stat.setString(1, name);//给占位符设置上内容
            stat.setString(2, pass);
            ResultSet rs = stat.executeQuery();//执行查询语句
            while (rs.next())//判断是否查询出数据
            {
                result= "1" ;
            }
            rs.close();
            connection.close();
        } catch (Exception e)
        {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }
        return result;
    }

    //查询数据
      public int getTypesLocation(String str){
        int count=1;
        typeLocationList=new ArrayList<EnviromentQrder>();//存放查询出的数据
        synchronized (this){
            try {

                connection=getSQLConnection("124.70.203.134", "sa", "Yelei193", "YoushangData");

                String sql = "SELECT * FROM flow WHERE flo_num LIKE '%"+ str +"%'or flo_state LIKE '%"+str+"%'or flo_client LIKE '%"+str+"%'or flo_factory LIKE '%"+str+"%'or flo_coding LIKE '%"+str+"%'or flo_cilentID LIKE '%"+str+"%'or flo_model LIKE '%"+str+"%'or flo_logo LIKE '%"+str+"%'or flo_proname LIKE '%"+str+"%'" ;
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                ResultSet resultSet=preparedStatement.executeQuery();

                //判断是否有下一个
                while (resultSet.next()){
                    //通过字段得到数值

                    String s1 = resultSet.getString("flo_state");
                    String s2 = resultSet.getString("flo_client");
                    String s3 = resultSet.getString("flo_factory");
                    String s4 = resultSet.getString("flo_num");
                    String s5 = resultSet.getString("flo_record");
                    String s6 = resultSet.getString("flo_coding");
                    String s7 = resultSet.getString("flo_cilentID");
                    String s8 = resultSet.getString("flo_model");
                    String s9 = resultSet.getString("flo_logo");
                    String s10 = resultSet.getString("flo_proname");
                    String s11 = resultSet.getString("flo_range");
                    String s12 = resultSet.getString("flo_unit");
                    String s13 = resultSet.getString("flo_reunit");
                    String s14 = resultSet.getString("flo_memunit");
                    String s15 = resultSet.getString("flo_frames");
                    String s16 = resultSet.getString("flo_backcolor");
                    String s17 = resultSet.getString("flo_closetime");
                    String s18 = resultSet.getString("flo_backtime");
                    String s19 = resultSet.getString("flo_revise");
                    String s20 = resultSet.getString("flo_cleRange");
                    String s21 = resultSet.getString("flo_cleShutdown");
                    String s22 = resultSet.getString("flo_gravity");
                    String s23 = resultSet.getString("flo_levFacSet");
                    String s24 = resultSet.getString("flo_cell");
                    String s25 = resultSet.getString("flo_plastic");
                    String s26 = resultSet.getString("flo_quantity");
                    String s27 = resultSet.getString("flo_delivery");
                    String s28 = resultSet.getString("flo_encase");
                    String s29 = resultSet.getString("flo_box");
                    String s30 = resultSet.getString("flo_ask");
                    String s31 = resultSet.getString("flo_bomVerify");
                    String s32 = resultSet.getString("flo_starv");
                    String s33 = resultSet.getString("flo_oliquan");
                    String s34 = resultSet.getString("flo_elequan");
                    String s35 = resultSet.getString("flo_elsequan");
                    String s36 = resultSet.getString("flo_facAlter");
                    String s37 = resultSet.getString("flo_fristMake");
                    String s38 = resultSet.getString("flo_fristChk");
                    String s39 = resultSet.getString("flo_ProSum");
                    String s40 = resultSet.getString("flo_spotChk");
                    String s41 = resultSet.getString("flo_out");
                    String s42 = resultSet.getString("flo_finish");

                    //将得到的数据存放到类中，然后存放到List中
                    typeLocationList.add(new EnviromentQrder("【订单序号】："+count,"【订单状态】："+s1,"【客户】：" + s2,"【工厂】：" +s3,"【制令单号】：" +s4,
                            "【订单临时变更】："+s5, "【产品编号】：" +s6,"【客户编号】" +s7,"【客户机型】： " +s8,"【LOGO】 ： " +s9,"【工厂机型】：" +s10,
                            "【量程精度】：" +s11,"【称重单位】：" +s12,"【断电开机】：" +s13,"【记忆单位】：" +s14,"【开机画面】：" +s15,"【背光颜色】：" +s16,
                            "【关机时间】：" +s17,"【背光时间】：" + s18,"【校机砝码】：" +s19,"【自有程序】：" +s20, "【内配功能】：" +s21,"【内重力加速度配功能】：" +s22,
                            "【出厂标准】：" +s23,"【电池】：" +s24,"【塑胶颜色】：" + s25,"【订单数量】：" +s26,"【交货日期】：" +s27,"【装箱方式】：" +s28,"【箱唛】：" + s29,
                            "【客户细节要求】：" +s30, "【物料需求提交状态】：" +s31,"【报缺情况】：" +s32,"【喷釉丝印】：" +s33,"【委外电镀】：" +s34,"【其他委外】：" +s35,
                            "【厂发变更记录】：" + s36,"【首件制作】：" +s37,"【首件确认】：" +s38,"【生产问题汇总】：" +s39,"【成品问题汇总】："+s40, "【出货操作】：" +s41,"【结单操作】：" +s42));
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return typeLocationList.size();
        }
      }

}
