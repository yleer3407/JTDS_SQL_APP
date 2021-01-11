package com.example.socket.linkdatabaseapplication.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.socket.linkdatabaseapplication.EnviromentQrder;
import com.example.socket.linkdatabaseapplication.R;

import java.util.List;

public class TestAdapter extends ArrayAdapter<EnviromentQrder> {
    private int resourceId;
    public TestAdapter(@NonNull Context context,  int textViewResourceId, @NonNull List<EnviromentQrder> objects) {
        super(context,  textViewResourceId, objects);
        resourceId=textViewResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        EnviromentQrder enviromentQrder=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView txt01 = view.findViewById(R.id.t1);
        TextView txt02 = view.findViewById(R.id.t2);
        TextView txt03 = view.findViewById(R.id.t3);
        TextView txt04 = view.findViewById(R.id.t4);
        TextView txt05 = view.findViewById(R.id.t5);

        txt01.setText(enviromentQrder.getNum());
        txt02.setText(enviromentQrder.getCilentID());
        txt03.setText(enviromentQrder.getCoding());
        txt04.setText(enviromentQrder.getMemunit());
        txt05.setText(enviromentQrder.getClosetime());
        return view;
    }
}
