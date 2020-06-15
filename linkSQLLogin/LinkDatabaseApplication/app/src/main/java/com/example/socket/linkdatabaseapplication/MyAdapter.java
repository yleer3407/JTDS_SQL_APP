package com.example.socket.linkdatabaseapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<EnviromentQrder> list_data;
    private Context context;
    private ViewHoled viewHold;

    public MyAdapter(ArrayList<EnviromentQrder> list_data, Context context) {
        this.list_data=list_data;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list_data.size();
    }

    @Override
    public Object getItem(int position) {
        return list_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView==null){
           viewHold= new ViewHoled();
           convertView= View.inflate(context,R.layout.main_item,null);
           viewHold.t0=convertView.findViewById(R.id.t0);
           viewHold.t1=convertView.findViewById(R.id.t1);
           viewHold.t2=convertView.findViewById(R.id.t2);
           viewHold.t3=convertView.findViewById(R.id.t3);
           viewHold.t4=convertView.findViewById(R.id.t4);
           viewHold.t5=convertView.findViewById(R.id.t5);
           viewHold.t6=convertView.findViewById(R.id.t6);
           viewHold.t7=convertView.findViewById(R.id.t7);
           viewHold.t8=convertView.findViewById(R.id.t8);
           viewHold.t9=convertView.findViewById(R.id.t9);
           viewHold.t10=convertView.findViewById(R.id.t10);

           viewHold.t11=convertView.findViewById(R.id.t11);
           viewHold.t12=convertView.findViewById(R.id.t12);
           viewHold.t13=convertView.findViewById(R.id.t13);
           viewHold.t14=convertView.findViewById(R.id.t14);
           viewHold.t15=convertView.findViewById(R.id.t15);
           viewHold.t16=convertView.findViewById(R.id.t16);
           viewHold.t17=convertView.findViewById(R.id.t17);
           viewHold.t18=convertView.findViewById(R.id.t18);
           viewHold.t19=convertView.findViewById(R.id.t19);
           viewHold.t20=convertView.findViewById(R.id.t20);

           viewHold.t21=convertView.findViewById(R.id.t21);
           viewHold.t22=convertView.findViewById(R.id.t22);
           viewHold.t23=convertView.findViewById(R.id.t23);
           viewHold.t24=convertView.findViewById(R.id.t24);
           viewHold.t25=convertView.findViewById(R.id.t25);
           viewHold.t26=convertView.findViewById(R.id.t26);
           viewHold.t27=convertView.findViewById(R.id.t27);
           viewHold.t28=convertView.findViewById(R.id.t28);
           viewHold.t29=convertView.findViewById(R.id.t29);
           viewHold.t30=convertView.findViewById(R.id.t30);

           viewHold.t31=convertView.findViewById(R.id.t31);
           viewHold.t32=convertView.findViewById(R.id.t32);
           viewHold.t33=convertView.findViewById(R.id.t33);
           viewHold.t34=convertView.findViewById(R.id.t34);
           viewHold.t35=convertView.findViewById(R.id.t35);
           viewHold.t36=convertView.findViewById(R.id.t36);
           viewHold.t37=convertView.findViewById(R.id.t37);
           viewHold.t38=convertView.findViewById(R.id.t38);
           viewHold.t39=convertView.findViewById(R.id.t39);
           viewHold.t40=convertView.findViewById(R.id.t40);
           viewHold.t41=convertView.findViewById(R.id.t41);
           viewHold.t42=convertView.findViewById(R.id.t42);
           convertView.setTag(viewHold);
       }else {
           viewHold=(ViewHoled) convertView.getTag();
       }
       //temp,devSerialNumber,ph,rongJy,zhuD,gaoMengSY, cod,bod5,anDan,total_lin,total_dan
        viewHold.t0.setText(list_data.get(position).getCount()+"");
        viewHold.t1.setText(list_data.get(position).getState()+"");
        viewHold.t2.setText(list_data.get(position).getClient()+"");
        viewHold.t3.setText(list_data.get(position).getFactory()+"");
        viewHold.t4.setText(list_data.get(position).getNum()+"");
        viewHold.t5.setText(list_data.get(position).getRecord()+"");
        viewHold.t6.setText(list_data.get(position).getCoding()+"");
        viewHold.t7.setText(list_data.get(position).getCilentID()+"");
        viewHold.t8.setText(list_data.get(position).getModel()+"");
        viewHold.t9.setText(list_data.get(position).getLogo()+"");
        viewHold.t10.setText(list_data.get(position).getProname()+"");

        viewHold.t11.setText(list_data.get(position).getRange()+"");
        viewHold.t12.setText(list_data.get(position).getUnit()+"");
        viewHold.t13.setText(list_data.get(position).getReunit()+"");
        viewHold.t14.setText(list_data.get(position).getMemunit()+"");
        viewHold.t15.setText(list_data.get(position).getFrames()+"");
        viewHold.t16.setText(list_data.get(position).getBackcolor()+"");
        viewHold.t17.setText(list_data.get(position).getClosetime()+"");
        viewHold.t18.setText(list_data.get(position).getBacktime()+"");
        viewHold.t19.setText(list_data.get(position).getRevise()+"");
        viewHold.t20.setText(list_data.get(position).getCleRange()+"");

        viewHold.t21.setText(list_data.get(position).getCleShutdowm()+"");
        viewHold.t22.setText(list_data.get(position).getGravity()+"");
        viewHold.t23.setText(list_data.get(position).getLevFacSet()+"");
        viewHold.t24.setText(list_data.get(position).getCell()+"");
        viewHold.t25.setText(list_data.get(position).getPlastic()+"");
        viewHold.t26.setText(list_data.get(position).getQuantity()+"");
        viewHold.t27.setText(list_data.get(position).getDelivery()+"");
        viewHold.t28.setText(list_data.get(position).getEncase()+"");
        viewHold.t29.setText(list_data.get(position).getBox()+"");
        viewHold.t30.setText(list_data.get(position).getAsk()+"");

        viewHold.t31.setText(list_data.get(position).getBomVerify()+"");
        viewHold.t32.setText(list_data.get(position).getStarv()+"");
        viewHold.t33.setText(list_data.get(position).getOliquan()+"");
        viewHold.t34.setText(list_data.get(position).getElequan()+"");
        viewHold.t35.setText(list_data.get(position).getElsequan()+"");
        viewHold.t36.setText(list_data.get(position).getFacAlter()+"");
        viewHold.t37.setText(list_data.get(position).getFristMake()+"");
        viewHold.t38.setText(list_data.get(position).getFristChk()+"");
        viewHold.t39.setText(list_data.get(position).getProSum()+"");
        viewHold.t40.setText(list_data.get(position).getSpotChk()+"");

        viewHold.t41.setText(list_data.get(position).getOut()+"");
        viewHold.t42.setText(list_data.get(position).getFinish()+"");

        return convertView;
    }


    static class ViewHoled{
        TextView t0;
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
        TextView t6;
        TextView t7;
        TextView t8;
        TextView t9;
        TextView t10;
        TextView t11;
        TextView t12;
        TextView t13;
        TextView t14;
        TextView t15;
        TextView t16;
        TextView t17;
        TextView t18;
        TextView t19;
        TextView t20;
        TextView t21;
        TextView t22;
        TextView t23;
        TextView t24;
        TextView t25;
        TextView t26;
        TextView t27;
        TextView t28;
        TextView t29;
        TextView t30;
        TextView t31;
        TextView t32;
        TextView t33;
        TextView t34;
        TextView t35;
        TextView t36;
        TextView t37;
        TextView t38;
        TextView t39;
        TextView t40;
        TextView t41;
        TextView t42;

    }

}
